from ruamel.yaml import YAML

# 파서 생성
yaml = YAML()

file_path = "example.yaml"
with open(file_path, 'r') as file:
    data = yaml.safe_load(file)


if 'age' in data:
    data['age'] = 35

if 'hobbies' in data:
    data['hobbies'].append('swimming')

with open(file_path, 'w') as file:
    yaml.dump(data, file)


print('수정된 데이터:')
print(data)