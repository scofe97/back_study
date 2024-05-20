from ruamel.yaml import YAML
import argparse
import os

def main():
    parser = argparse.ArgumentParser(description="values.yaml 파일 수정", epilog="작성: Journalctl(sw.lee).")
    parser.add_argument('-n', '--name', required=True, help=': 업데이트할 차트 이름')
    parser.add_argument('-t', '--tag', required=True, help=': 새로운 이미지 태그')
    args = parser.parse_args()

    # 파일 경로를 지정합니다.
    file_path = 'values.yaml'
    if not os.path.exists(file_path):
        raise FileNotFoundError(f"{file_path} 파일을 찾을 수 없습니다.")

    yaml = YAML()
    values = None

    try:
        # YAML 파일을 읽어옵니다.
        with open(file_path, 'r') as file:
            values = yaml.load(file)
    except Exception as e:
        raise ValueError(f"YAML 파일을 읽거나 파싱할 수 없습니다. 파일 형식이 올바른지 확인하십시오. 오류: {e}")

    if not values:
        raise ValueError("파싱된 YAML 파일이 비어 있거나 잘못되었습니다. 파일 형식을 확인하십시오.")

    # 차트 이름이 YAML 데이터에 있는지 확인합니다.
    if args.name not in values:
        raise KeyError(f"YAML 파일에서 '{args.name}' 차트 이름을 찾을 수 없습니다.")

    # 'image'와 'tag' 구조를 확인하고 값을 업데이트합니다.
    try:
        values[args.name]['image']['tag'] = args.tag
    except KeyError as e:
        raise KeyError(f"이미지 태그를 업데이트하는 중 오류가 발생했습니다. 누락된 키: {e}")

    # 업데이트된 YAML을 파일에 기록합니다.
    try:
        with open(file_path, 'w') as file:
            yaml.dump(values, file)
        print(f"'{args.name}' 차트의 이미지 태그가 '{args.tag}'로 성공적으로 업데이트되었습니다.")
    except Exception as e:
        raise ValueError(f"YAML 파일에 기록할 수 없습니다. 오류: {e}")

if __name__ == "__main__":
    main()
