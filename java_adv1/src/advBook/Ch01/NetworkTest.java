package advBook.Ch01;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;

public class NetworkTest {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        var client = HttpClient.newBuilder().build();

        var uri = new URI("https://google.com");
        var request = HttpRequest.newBuilder(uri).build();

        // HTTP 요청을 동기적으로 실행하고 응답 저장
        // 완로될떄까지 블로킹
        HttpResponse<String> response = client.send(
                request
                // 응답본문을 어떻게 처리할지 알려주는 핸들러(문자열 반환)
                , HttpResponse.BodyHandlers.ofString(Charset.defaultCharset()));

        System.out.println("response = " + response.body());
        System.out.println("=============================================");

        // HTTP2 멀티 플렉싱 방식(비동기형식으로 처리)
        // 3번의 요청을 비동기적으로 반환한다.
        var handler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture.allOf(
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println("response = " + resp)),
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println("response = " + resp)),
                client.sendAsync(request, handler)
                        .thenAccept((resp) -> System.out.println("response = " + resp))
        ).join();

    }
}
