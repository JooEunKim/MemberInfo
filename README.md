# MemberInfo

- 클래스 member 생성
  - 인스턴스변수 : name, age, phonenumber
  
- 인터페이스 Directory 생성
  - 메서드
    - name lookup() : 없는 이름을 조회하는 경우, customized된 exception 으로 예외처리
    - void insert(name, age, phoneNum)
    - member delete(name)
    - void save() : txt 파일 저장 (파일 저장시 이름으로 정렬)
    - void print() 
    
- 프로그램에서 질의를 통해 list 또는 linkedlist 구현체 설정
  - list (ArrayList) 구현 : ListDirectory 
  - LinkedList 구현 : LinkedListDirectory 
- 특정 디렉토리에 있는 파일 리스트 중에 선택 할 수 있는 질의 필요
- exit() 함수가 실행하기 전까지는 프로그램이 종료되지 않아야 함
- 산출물
  - class diagram
  - sequence diagram
  - jUnit 단위 테스트
