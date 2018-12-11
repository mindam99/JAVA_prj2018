# JAVA_prj2018
Computer Programming II Project
이 프로젝트는 자바를 활용하여 암호화 및 복호화 함수를 구현하기 위해 만들어졌습니다.
고전 암호 4가지에 대한 함수를 지원합니다. 지원하는 기능들은 다음과 같습니다.

<암호화>
1. Shift cipher -> 임의의 key 값 입력 가능
2. Substitution cipher -> 임의의 S-box 입력 가능
3. Vigenere cipher -> 임의의 keyword 입력 가능
4. Transposition cipher -> key cycle이 5라는 가정 하에 암호화

<복호화>
1. Shift cipher -> exhaustive search
2. Substitution cipher -> 완전 복호화가 아닌 힌트 제공까지
3. Vigenere cipher -> keyword를 안다는 가정 하에 복호 가능 / key length를 추정해 주는 kasiski examination 함수 기능
4. Transposition cipher -> key cycle이 5라는 가정 하에 exhaustive search
