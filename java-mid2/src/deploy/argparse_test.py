import argparse

parser = argparse.ArgumentParser(description="두 숫자의 합을 계산합니다.")

parser.add_argument('-n1', '--num1', type=int, required=True, help='계산에 필요한 첫 번째 숫자')
parser.add_argument('-n2', '--num2', type=int, required=True, help='계산에 필요한 두 번째 숫자')
args = parser.parse_args()

result = args.num1 + args.num2
print(f"두 숫자의 합은: {result}")