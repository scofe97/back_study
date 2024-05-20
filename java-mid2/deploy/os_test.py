import os

# 현재 작업 디렉토리 가져오기
current_dir = os.getcwd()
print(f"현재 작업 디렉토리: {current_dir}")

# 현재 디렉토리의 파일 목록 출력
file_list = os.listdir(current_dir)
print("디렉토리 내 파일:")
for file_name in file_list:
    print(f" - {file_name}")
