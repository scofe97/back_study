package main

import (
	"crypto/aes"
	"crypto/cipher"
	"crypto/md5"
	"crypto/rand"
	"crypto/rsa"
	"io"
	"testing"
)

func prepareRSA() ([]byte, []byte, *rsa.PrivateKey, error) {
	sourceData := make([]byte, 128)
	label := []byte("")
	_, err := io.ReadFull(rand.Reader, sourceData)
	if err != nil {
		return nil, nil, nil, err
	}
	privateKey, err := rsa.GenerateKey(rand.Reader, 2048)
	if err != nil {
		return nil, nil, nil, err
	}
	return sourceData, label, privateKey, nil
}

func BenchmarkRSAEncryption(b *testing.B) {
	sourceData, label, privateKey, err := prepareRSA()
	if err != nil {
		b.Fatal(err)
	}
	publicKey := &privateKey.PublicKey
	md5hash := md5.New()
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_, err := rsa.EncryptOAEP(md5hash, rand.Reader, publicKey, sourceData, label)
		if err != nil {
			b.Error(err)
		}
	}
}

func BenchmarkRSADecryption(b *testing.B) {
	sourceData, label, privateKey, err := prepareRSA()
	if err != nil {
		b.Fatal(err)
	}
	publicKey := &privateKey.PublicKey
	md5hash := md5.New()
	encrypted, err := rsa.EncryptOAEP(md5hash, rand.Reader, publicKey, sourceData, label)
	if err != nil {
		b.Fatal(err)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_, err := rsa.DecryptOAEP(md5hash, rand.Reader, privateKey, encrypted, label)
		if err != nil {
			b.Error(err)
		}
	}
}

func prepareAES() ([]byte, []byte, cipher.AEAD, error) {
	sourceData := make([]byte, 128)
	_, err := io.ReadFull(rand.Reader, sourceData)
	if err != nil {
		return nil, nil, nil, err
	}
	key := make([]byte, 32)
	_, err = io.ReadFull(rand.Reader, key)
	if err != nil {
		return nil, nil, nil, err
	}
	nonce := make([]byte, 12)
	_, err = io.ReadFull(rand.Reader, nonce)
	if err != nil {
		return nil, nil, nil, err
	}
	block, err := aes.NewCipher(key)
	if err != nil {
		return nil, nil, nil, err
	}
	gcm, err := cipher.NewGCM(block)
	if err != nil {
		return nil, nil, nil, err
	}
	return sourceData, nonce, gcm, nil
}

func BenchmarkAESEncryption(b *testing.B) {
	sourceData, nonce, gcm, err := prepareAES()
	if err != nil {
		b.Fatal(err)
	}
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		gcm.Seal(nil, nonce, sourceData, nil)
	}
}

func BenchmarkAESDecryption(b *testing.B) {
	sourceData, nonce, gcm, err := prepareAES()
	if err != nil {
		b.Fatal(err)
	}
	encrypted := gcm.Seal(nil, nonce, sourceData, nil)
	b.ResetTimer()
	for i := 0; i < b.N; i++ {
		_, err := gcm.Open(nil, nonce, encrypted, nil)
		if err != nil {
			b.Error(err)
		}
	}
}
