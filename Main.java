// 문제 : 아래가 실행되도록 해주세요.
// 조건 : 배열을 사용할 수 없습니다.

class Main {
	public static void main(String[] args) {
		사람인력관리소 a사람인력관리소 = new 사람인력관리소();

		// 문제를 보고 알수있는 정보 : '글자열','정수'를 넘겨주고 있음
		a사람인력관리소.add사람("홍길순", 33); // 밑에 글처럼 출력
		// 출력 : 나이가 33살인 1번째 사람(홍길순)이 추가되었습니다.
		a사람인력관리소.add사람("홍길동", 20); // 글자열,정수를 넘겨주고 있음
		// 출력 : 나이가 20살인 2번째 사람(홍길동)이 추가되었습니다.
		a사람인력관리소.add사람("임꺽정", 30);
		// 출력 : 나이가 30살인 3번째 사람(임꺽정)이 추가되었습니다.

		// 문제를 보고 알수있는 정보 :a사람인력관리소안에 있는 변수를 이용하여 get사람를 조작하고 그에 맞는 리턴값을
		// 사람타입만 들어갈 수 있는 변수 a사람1에 넣겠다 => "리턴타입은 사람이다"를 알수 있다
		사람 a사람1 = a사람인력관리소.get사람(1);
		a사람1.자기소개();
		// 출력 : 저는 1번, 홍길순, 33살 입니다.

		사람 a사람2 = a사람인력관리소.get사람(2); // ※6 사람 a사람2 = a사람인력관리소.get사람(2) == 사람 a사람2 = a사람1 똑같다고 볼수 있다
		a사람2.자기소개();
		// 출력 : 저는 2번, 홍길동, 20살 입니다.

		사람 a사람3 = a사람인력관리소.get사람(3);
		a사람3.자기소개();
		// 출력 : 저는 3번, 임꺽정, 30살 입니다.

	}
}

//1.class 사람인력관리소이 필요하다 
class 사람인력관리소 {

	// ★배열사용 6
	사람[] 사람들;
	

	// 5.사람이 들어올때 마다 1씩 증가하여 번호를 매기는 변수
	int 마지막사람번호;

	사람인력관리소() {
		사람들 = new 사람[100];// ★배열사용 사람들을 담을 new사람 100개를 할당 =>사람100를 담을 배열을 선언
		
		마지막사람번호 = 0;
		// 5 - 2 처음 객체를 만들자마자 시작하는 생성자를 이용하여 변수 "마지막사람번호"를 초기화
	}
	

	// 2.사람인력관리소에 있는 "add사람"함수가 필요(매개변수 String, int) 리턴타입 X (void함수)
	void add사람(String 이름, int 나이) {

		int 번호 = 마지막사람번호 + 1;// 5 -3 add사람을 할때 마다 1씩 증가

		// 함수에 만든 변수는 함수가 죽으면 사라진다.(지역변수) 따로 저장할 공간이 필요
		// 함수안에 만들어진 변수를 저장할수 있는 공간(new 사람) a사람에 나이와 이름을 저장
		사람 a사람 = new 사람(); // ※사람정보를 담아놓는 폴더를 저장하는 '사람'만 담을수있는 "a사람"
		a사람.번호 = 번호;
		a사람.나이 = 나이;
		a사람.이름 = 이름;
		System.out.printf("나이가 %d살인 %d번째 사람(%s)이 추가되었습니다.\n", 나이, 번호, 이름);


		
		//☆배열사용6-2(번호는 1이고 add사람이 시작하면 1씩증가하므로 반복사용없이 배열에 대입이 가능하다.)
		사람들[번호 - 1] = a사람;

		마지막사람번호++; // 5 - 4 add사람을 할때마다 변수 마지막사람번호를 1씩 증가(사람의 번호를 매길수있음)
	}

	// 3.사람만 들어갈 수 있는 리턴이 있는 함수
	사람 get사람(int 번호) {

		return 사람들[번호 - 1]; //☆배열사용6-3(번호는 1이고 add사람이 시작하면 1씩증가하므로 반복사용없이 배열에 있는 리모콘으로 호출이 가능하다.)
	}

}

//1. class 사람이 필요하다
class 사람 {

	int 번호;
	String 이름;
	int 나이;

	// 4.class 사람은 "자기소개"의 함수를 갖고 있다.
	void 자기소개() {
		System.out.printf("저는 %d번, %s, %d살 입니다.\n", 번호, 이름, 나이);
	}
}