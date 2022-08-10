package word;

public class Math {
	/*
	<수의 범위>

	digit : 0에서 9까지의 숫자

	whole number : 0과 자연수

	natural number(=counting number) : 자연수

	integer : 정수

	negative number : 음수 

	positive number : 양수

	rational number : 유리수

	irrational number : 무리수

	real number : 실수

	imaginary number : 허수

	complex number : 복소수

	consecutive integer : 연속하는 정수

	real-valued : 실수를 사용한

	 

	<자릿수>

	place value : 자릿값

	units : 일의자리

	tens : 십의 자리

	hundreds : 백의자리

	thousands : 천의자리

	ten thousands : 만의 자리

	hundred thousands : 십만의 자리

	millions : 백만의 자리

	 

	tenths : 0.1의 자리

	hundredths : 0.01의 자리

	 

	<분수>

	fraction : 분수

	denominator : 분모

	common denominator : 공통분모

	least common denominator : 최소공통분모

	numerator : 분자

	equivalent fraction : 동치분수

	 

	proper fraction : 진분수

	improper fraction : 가분수

	mixed fraction : 대분수

	 

	reciprocal of a fraction : 분수의 역(분모와 분자를 바꾼 것)

	 

	<배수와 약수>

	factor : 약수(인수)

	multiple : 배수

	common factor : 공약수

	common multiple : 공배수

	greatest common factor(=greatest common divisor=highest common factor) : 최대공약수

	least common multiple : 최소공배수

	 

	<소수와 합성수>

	prime number : 소수(1과 자기자신을 제외하고는 나누어떨어지는 수가 없는 자연수)

	composition number : 합성수

	factorization : 인수분해

	prime factor : 소인수

	prime factorization : 소인수분해

	 

	<소수(정수가 아닌 수)>

	decimal number : 소수(소숫점이 있는 수)

	decimal point : 소숫점

	 

	<백분율>

	percentage : 백분율(%)

	absolute value : 절댓값

	change : 새로 변화한 값에서 예전 값을 뺀것(new-old=change)

	difference : 차(두 값의 차)

	average : 평균

	 

	error : 오차(예상한 값에서 실제 값을 뺀것/절댓값)

	absolute error : 절대 오차 (the absolute value of the difference. 차의 절댓값)

	relative error : 상대 오차 (the absolute error divided by the measured value. 절대 오차를 측정값으로 나눈 것.)

	 

	 

	<사칙연산>

	addition : 덧셈

	subtraction : 뺄셈

	multiplication : 곱셈

	division : 나눗셈

	product : 곱

	sum : 합

	 

	<곱셈>

	square : 제곱

	perfect square : 완전제곱(정수의 제곱)

	square root : 제곱근

	radical : 근호(루트 기호)

	exponent : 지수(멱지수)

	negative exponent : 음의 지수

	coefficient : 계수

	leading coefficient : 최고차항의 계수

	 

	[Algebra]

	<연산법칙>

	commutative law : 교환법칙

	associative law : 결합법칙

	distributive law : 분배법칙

	 

	<식>

	polynomial : 다항식

	binomial : 이항식

	trinomial : 3항식

	distribute : 분배하다

	equation : 방정식

	inequality : 부등식

	proportional : 비례하는

	inverse variation / vary inversely : 반비례

	inversely proportional to ~ : ~에 반비례하다

	direct variation / vary directly : 정비례

	 

	 

	 

	<방정식>

	slope intercept form : y=ax+b 형태

	 

	<소수>

	repeating decimal : 순환소수

	 

	 

	<집합>

	subset : 부분집합

	 

	 

	<행렬>

	matrix : 행렬

	determinant : 행렬식

	 

	<그래프>

	linear : 직선의, 일차의

	pictograph : 그림 문자, 상형문자, 통계 그래프

	ordered pair : 순서쌍

	slope : 기울기

	domain : 영역, 범위

	parabola : 포물선

	hyperbola : 쌍곡선

	quadrant : 사분면

	 

	<도형>

	line : 직선(시작과 끝이 없는 것)

	line segment : 선분(시작과 끝이 있는 것)

	ray : 반직선(시작만 있고 끝은 없는 것)

	radius : 반지름 (복수 : radii)

	diameter : 지름

	circumference : 원주(원 둘레)

	ellipse : 타원

	vertex : 꼭짓점

	 

	 

	<보충 용어>

	unit : 단위

	parameter : 변수

	variable : 변수

	parenthesis : 괄호

	properties : 성질

	 

	about : 약, 예) 49.5 는 약 50

	absolute value : 절대값, '원점에서 어떤 점 사이의 거리', -3 과 +3 의 절대값은 3

	acute angle : 예각

	acute triangle : 예각 삼각형

	addition : 덧셈

	alternate (or interior) angle : 엇각, (서로) 어긋나게 놓여진 각

	angle : 각

	angle of cimcumference : 원주각, 원주위의 한점 P에서 그은 두 개의 현 PA, PB 가 이루는 각이 호 AB 에 대한 원주각

	angle of intersection : 교각

	angular measure : 각도

	approximate value : 근사값

	arbitrariness : 임의 (~뜻에 맡기다), 임의로, 자기 뜻대로 하다, 영어의 any 와 같은뜻

	arc : 호, '나무로 만든 활', 원주위의 두 점 사이의 부분

	are : 아르, 100 m2 가 1 아르 (한변이 10 m 인 정사각형의 넓이), 기호는 a

	area : 넓이

	associative law : 결합법칙, 예) 덧셈의 결합법칙 a + (b + c) = (a + b) + c

	assumption : 가정, p -> q, 즉 "p 이면 q 이다" 에서 p 는 가정이다. conclusion 의 반대

	augend : 피가수, 더해지는수, 덧셈에서

	average : 평균, 어떤 손해를 보았을 때 그 손해를 여러 소유주가 똑같이 분담한 그 양을 의미한다.

	axis : 축

	axis of coordinate : 좌표축, x 축과 y 축

	axis of rotation : 회전축

	band graph : 띠 그래프, 전체에 대한 각 부분의 비율을 띠의 길이로 나타낸 그래프

	bar graph : 막대그래프

	base : 밑, 밑변, 23 에서 2 가 base 이다.

	base plane : 밑면, 각기둥이나 원기둥에서 아래있는 면이나 위에 있는 면

	binary system : 이진법

	body of rotation : 회전체, 한 직선을 축으로 평면도형을 회전시킬 때 생기는 입체도형

	borrowing : 받아내림, 13 - 7 = (10 - 7) + 3 = 6, regrouping 이라고도 한다.

	brace : 중괄호

	bracket : 대괄호

	calculation : 셈, 계산, 자갈 (라틴어로 calc) 을 이용하여 할 수 있는 정도의 간단한 계산

	capacity : 들이 (용기의 부피), 용적, volume : 부피

	carrying : 받아올림, 6 + 7 = (6 + 4) + 3 = 13, regrouping 이라고도 한다.

	center : 중심

	center of gravity : 무게중심, center of mass 라고도 한다. gravity : 중력, 무게

	center of similarity : 닮음의 중심, 닮음의 위치에 있는 두 삼각형에서 대응하는 점을 이은 직선은 모두 한점을 지남.

	central angle : 중심각, 원위에 호 AB 가 있을 때 그 호와 원의 중심 O 가 만드는 각 AOB 를 호 AB 에 대한 중심각이라 함

	central line : 중심선, 두 원이 인접해 있을 때 이 두원의 중심을 지나는 직선

	chord : 현, 활시위, 악기의 현 (string), 원주위의 두 점 A, B 가 있을 때 호 AB 를 의미

	circle : 원

	circular cone : 원뿔

	circular cylinder : 원기둥

	circular graph : 원그래프

	circumcenter : 외심, 삼각형의 외접원의 중심

	circumference : 둘레, 도형의 가장자리를 따라 한 바퀴 돈 길이, periphery : 둘레, perimeter : 둘레

	circumference : 원주 (원 둘레, 원의 가장자리의 길이)

	circumscribed circle : 외접원, 다각형이 어떤 원에 내접하면 이 원은 다각형의 외접원이 된다.

	circumscription : 외접 (주위에 경계선을 긋다), 어떤 원의 외부에서 그 원이 다각형의 모든 변에 접하고 있을 때

	class : 계급, 예) 통계에서 변량을 나눈 구간, class interval : 계급의 크기, class mark : 계급의 중앙값

	codomain : 공역, 정의역

	codomain : 공역, y 가 x 의 함수일 때 변수 x 가 취할 수 있는 값의 범위 정의역 (domain), y 의 범위는 codomain (공역)

	coefficient : 계수, 예) 2x 에서 2 는 문자 x 의 계수

	common denominator : 공통분모

	common divisor : 공약수, greatest common divisor (or factor, measure) : 최대공약수

	common factor : 공통인수

	common multiple : 공배수, least common multiple : 최소공배수

	commutative law : 교환법칙, 예) a + b = b + a

	compass : 컴퍼스, '걸음을 걸을 때 두 다리를 벌린 너비'

	complement : 여집합

	composite number : 합성수, 1 보다 큰 자연수 중에서 소수가 아닌수를 합성수라고 한다. compound number 와 같은뜻

	computation : 셈, 계산, 함께 숙고해서 해결해야 할 정도의 복잡한 계산, 함께 (co), 가지치기를 하다 (putare)

	concentration : 농도

	conditions of congruence : 합동조건

	congruence : 합동, 두 도형에서 한 도형을 옮겨서 다른 도형과 완전히 포개지면 두 도형은 합동

	constant : 상수

	construction : 작도, 자와 컴퍼스만을 이용하여 도형을 그리다.

	continued ratio : 연비 (3 개 이상의 양의 비), 예) 3 : 4 : 5

	coordinate : 좌표, 순서쌍 P(2, 3)에서 2 는 점 P 의 x 좌표, axis of coordinate 좌표축, coordinate plane 좌표평면

	coordinate plane : 좌표평면, '모든 점의 위치가 좌표로 나타내어지는 평면'

	correlation : 상관관계, 두 변량 x, y 가 있을 때 x 가 커짐에 따라 y 의 값이 커지거나 작아지는 관계

	correlation diagram (or table) : 두 변량 x, y 의 상관관계를 순서쌍 (x, y) 를 이용하여 좌표평면에 그림으로 나타낸 것

	correspondence : 대응, 예) 집합 X 의 한 원소 x 가 집합 Y 의 한 원소 y 와 짝지어 진다면 x 와 y 가 대응

	corresponding angle : 동위각, 두 직선이 한 직선과 만나서 이루는 각 중에서 서로 같은 위치에 있는 각

	cosine : 코사인, complemental sine 의 줄임말, sine 의 여각을 의미한다.

	cube : 세제곱

	cube : 정육면체 (regular hexahedron)

	cubic meter : 세제곱미터

	cumulative frequency : 누적도수

	curve : 곡선

	decimal : 소수, 십진법, circulating (repeating) decimal : 순환소수, to 5 places for decimals : 소수점 5자리 까지

	decimal expansion : 십진법 전개식, 예) 237 = 2 x 102 + 3 x 10 + 7 x 1

	decimal fraction : 소수 (小數, 작은수), 원래의 의미는 십진분수, 소수점 (decimal point)

	decimal point : 소수점 (小數)

	decimal system : 십진법, decimus (라틴어, 10)에서 나온말

	decimalism : 십진법

	definition : 정의

	degree : 각도, '사다리에서 발을 디디는 곳' 의 의미

	degree : 도, 각도

	degree : 차수, '계속 이어진 횟수', 예) 5 x3 에서 지수 3 은 x 가 3 회 곱해짐, 따라서 이 단항식의 차수는 3 이다.

	demonstration : 증명, proof 와 같은 의미로 사용된다. '논증하다, 설명하다' 라는 뜻도 있다.

	denominator : 분모, "이름붙이는 사람" 의 의미, 3/5 를 three fifth 라고 읽는다.

	determination condition : 결정조건, 예) 삼각형의 결정조건

	development figure : (입체도형의) 전개도, '입체도형을 하나의 평면도형으로 만들다'

	diagonal (line) : 대각선

	diameter : 지름, dia 는 '~을 가로지르다' 라는 뜻이 있다. 반지름은 radius

	difference : 차이, 뺄셈의 의미

	difference set : 차집합, 두 집합 A, B 에서 A 의 원소로서 B 의 원소가 아닌 모든 원소의 집합

	digit : 숫자, digitus (라틴어, 손가락)에서 나온말

	direct measurement : 직접측정

	direct proportion : 정비례

	disjoint : 서로소 (서로에 대한 소수), 2 와 3, 9 와 10 과 같이 공약수가 1 뿐인 두 자연수

	distribution : 분포

	distributive law : 분배법칙, a(b + c) = ab + ac

	dividend : 피제수, 나누어지는수, 나눗셈에서

	divisible : 나누어 떨이지다

	division : 나눗셈, quotient : 몫 , remainder : 나머지

	divisor (or measure) : 약수 (간략히 하는 수), divisor (약수도 결국은 나누는 수), 예) 6 의 약수는 1, 2, 3, 6

	divisor : 제수, 나눗셈

	domain (of definition) : (변수 x 의) 정의역, y 가 x 의 함수일 때 변수 x 가 취할 수 있는 값의 범위, y 는 codomain (공역)

	dotted line : 점선

	dotted line : 점선

	edge : 모서리

	edge : 변

	element : 원소

	elimination : 소거

	empty set : 공집합

	equality : 등식

	equality sign : 등호, =

	equation : 방정식, 서로 똑같게 하기,

	equation of a (straight) line : 직선 방정식, 일차방정식

	Eratosthenes' sieve : 에라토스테네스의 체, 소수를 찾을 때 2 의 배수를 지우고, 3 의배수, 5 의 배수를 지워서 찾음

	error : 오차

	even number : 짝수

	event : 사건

	expansion : (수식의) 전개, 전개식, 단항식과 다항식의 곱을 하나의 다항식으로 나타낸 것, 입체도형의 전개 (development)

	experiment (or trial) : 시행, 실험, 시도

	exponent : 지수, 35에서 5 는 3 이 몇 번 곱해져 있는지를 가리킨다.

	exponential law : 지수법칙, law of exponent, am x an = am+n 등등을 말한다.

	expression (or formula) : 식, 표현, 공식

	exterior angle : 외각, 다각형에서 한 내각의 밖에 있는 각

	face : 면

	factor : 인수, 예) 6 = 2 x 3에서 2 와 3 을 6 의 인수라고 한다. factorization : 인수분해

	figure : 도형, 예) 평명도형, 입체도형

	finite decimal : 유한 소수, 예) 1/4 는 소수로 나타내면 0.25 로 유한한 소수

	finite set : 유한 집합

	formula : 공식

	formula : 식 (expression), 공식

	four fundamental rules of arithmetics : 사칙연산

	fraction : 분수, denominator : 분모, numerator : 분자

	frequency : 도수, 통계에서 각 계급에 속하는 자료의 수

	frequency distribution : 도수분포

	frequency distribution polygon : 다각형, 도수분포를 히스토그램으로 나타낸다음 각 직사각형의 윗변의 중점을 선으로 연결

	function : 함수, 기능, 작용, 수행의 의미, 각각의 값에 작용하는 일련의 연산

	generating line : 모선, 예) 원뿔에서 꼭지점과 밑면을 이루는 원의 한점을 이은 선, 이 선이 움직여서 원뿔이 만들어짐

	geometry : 기하

	graph : 그래프, 직선, 점선, 곡선, 막대그래프, 그리스어 graphein (새기다, 긁다)에서 온 것

	graph of broken lines : 꺽은선 그래프, 막대그래프에서 각 막대의 끝을 꺽은선으로 연결한 그래프

	greater than : 초과, ~보다 큰

	greatest common divisor : 최대공약수

	hectare : 헥타르, 10,000 m2 가 1 헥타르 (한변이 100 m 인 정사각형의 넓이), 기호는 ha

	height : 높이

	hexahedron : 육면체 (여섯 면을 가진 입체도형)

	histogram : 히스토그램, '똑바로 선 막대 그림', 계급을 가로축에 도수를 세로축으로 직사각형을 차례대로 만든 그래프

	hypotenuse : (직각 삼각형의 가장 긴) 빗변, hypo 는 sub, tenuse 는 tend (내뻗치다, 쭉뻗다 는 의미)

	identical : 상등, 서로 같은

	identity : 항등식, 예) 3x = x + 2x 는 x 가 어떤 값을 갖더라도 항상 참이 된다. 이와같은 등식이 항등식이다.

	improper fraction : 가분수, 분자가 분모보다 커진 경우

	incenter or inner center : 내심, 내접원의 중심

	inequality : 부등식,

	inequality sign : 부등호, <, >, ≤, ≥ 등등

	infinite decimal : 무한소수, 소수점 아래로 0 이 아닌 숫자가 무한히 많은 소수, 예) 1/3, 3.141592..(순환하지 않는 무한소수)

	infinite set : 무한집합

	inner opposite angle : 내대각, 예) 사각형에서 내각의 반대쪽에 있는 것

	inscribed circle : 내접원

	inscription : 내접, 예) 다각형이 원에 내접하다. inscribe : 새기다

	integer : 정수, '손대지 않은', 분수처럼 손을대서 나눈 것이 아니라 그대로 둔 것,

	intercept : 절편, x 절편, y 절편, 일차함수의 그래프가 x 축과 만나는 점이 x 절편

	internal angle : 내각

	intersection : 교집합

	intersection point : 교점

	inverse (number) : 역수, 예) 분수 3/4 의 역수는 4/3

	inverse (or converse) : 역, "p 이면 q 이다" 의 역은 "q 이면 p 이다"

	inverse proportion : 반비례, reciprocal proportion

	irrational number : 무리수, 두 정수의 비로 나타낼 수 없는 수

	irreducible fraction : 기약분수, 약분을 다한 분수

	isosceles right angle : 직각이등변삼각형, isosceles 는 '이등변'

	isosceles trapezoid : 등변사다리꼴

	known number : 기지수, known quantity : 수에 한정하지 않는 것....

	known quantity : 기지수

	lateral face : 옆면

	law : 법칙

	least common multiple : 최소공배수

	length : 길이

	less than : 미만, ~보다 작은

	limit of error : 오차의 한계

	line of intersection : 교선

	line segment : 선분, 직선의 한 부분, 직선을 마디로 나누었을 때의 그 분절

	line symmetry : 선대칭

	linear : 일차, quadratic : 이차

	linear equation : 일차방정식

	linear expression : 일차식

	linear function : 일차함수, 함수 y = f(x)에서 y 가 x 에 관한 일차식으로 나타내어지는 함수

	linear inequality : 일차부등식, 예) (일차식)>0, (일차식)≥0, (일차식)<0, (일차식)≤0 의 하나로 표현

	lower base : 아랫변, 사다리꼴에서 아래에 있는 변

	mass : 질량 (중력가속도를 감안하지 않은 무게), 수학에서의 무게는 질량을 의미

	maximum : 최대값

	mean : 평균, '중간의', average

	measure : 측정

	median line : 중선, 삼각형의 꼭지점과 그 대변의 중점을 이은 선분

	mental computation (or mental arithmetic) : 암산

	meter : 빛이 진공에서 299,792,458 분의 1 초동안 진행한 거리

	method of elimination by adding and subtracting : 가감법, 소거법, (연립방정식)에서 미지수를 소거하여 해를 구함

	middle point : 중점, midpoint, 선분의 양끝으로부터 같은 거리, 즉 한가운데 있는 점

	milimetre : 밀리리터, milimeter 과 같다.

	minimum : 최소값

	minuend : 피감수, 감해지는수, 뺄셈에서

	mixed fraction : 대분수, 정수와 분수가 혼합되어 있다.

	monomial : 단항식, 예) 3x , 4ab

	multiple : 배수

	multiple root : 중근, 이차방정식의 두 근이 중복되어 있을 때 이 근을 중근이라 한다.

	multiplicand : 피승수, 곱해지는수, 곱셈에서

	multiplication : 곱셈

	multiplication table : 구구단

	multiplication table : 구구단

	natural number : 자연수, '1, 2, 3, 4, ....'

	negative correlation : 음의 상관관계, 두 변량 x, y 가 있을 때 x 가 커짐에 따라 y 의 값이 작아지는 관계

	negative number : 음수

	not greater than : 이하, 또는 less than or equal to

	not less than : 이상, not smaller than 도 같은 뜻이다.

	number line : 수직선, 수직선은 실수에 대응되는 점들로 메워져 있으므로 실수의 직선

	numbers of cases : 경우의 수

	numerator : 분자, "계산하는 사람" 의 의미

	oblique line : 사선, 빗금

	obtuse angle : 둔각, obtuse : 무디다, 뭉툭하다

	obtuse triangle : 둔각삼각형, 한각이 둔각인 삼각형

	odd number : 홀수, 한자에서는 기수, 짝수는 우수 (even number)

	operation : 연산 (셈을 행하다)

	opposite angle : 대각

	opposite side : 대변, 마주보는 변, side or edge

	ordered pair : 순서쌍, 좌표평면에서 점의 위치, 순서쌍 (3, 2) 와 (2, 3) 은 같지 않다.

	origin : 원점, 좌표평면에서 x 축과 y 축의 교점

	orthocenter : 수심 (수직선의 중심), 삼각형의 세 꼭지점에서 각각의 대변에 내린 세 수선이 만나는 점, ortho : 直

	orthogonality : 직교 (수직으로 교차)

	orthogonality : 직교, 두 직선이 직각으로 만나다. 수직과 같은 의미 (perpendicularity)

	parabola : 포물선, para 는 '평행하다', ballein 은 '던지다' 를 의미한다.

	parallel : 평행

	parallel translation : 평행이동

	parallelogram : 평행사변형, gram 은 '그려진 선' 을 의미한다

	parenthesis : (소)괄호, brace : 중괄호, bracket : 대괄호

	parenthesis : 소괄호

	pentagon : 오각형

	percent : 백분율, '100 에 대하여 얼마'

	perfect square expression : 완전 제곱식, 다항식 전체가 완전하게 제곱의 형태, 예) 3(a + b)2, (x + 1)2

	perimeter : 둘레, 도형의 가장자리를 따라 한 바퀴 돈 길이

	permille : 천분율, '천에 대하여 얼마', percent 는 백분율

	perpendicular : 수선 (수직인 직선), 수직, 두 직선이 서로 수직일 때 한 직선이 다른 한 직선의 수선이다.

	perpendicular bisector : 수직이등분선, 수직으로 이등분하는 직선

	perpendicularity : 수직

	plane : 평면

	plane figure : 평면도형

	point : 점

	point symmetry : 점대칭

	polygon : 다각형

	polyhedron : 다면체, 면이 많은 입체 도형, hedron : 바닥

	polynomial : 다항식, 2x - 4x2 은 2x 와 -4x2 의 합으로 이루어진 다항식

	position of similarity : 닮음의 위치, 두 삼각형의 대응되는 점을 이은 직선이 모두 한점을 지남

	positive correlation : 양의 상관관계, 두 변량 x, y 가 있을 때 x 가 커짐에 따라 y 의 값이 커지는 관계

	positive number : 양수

	power : 거듭제곱, square : 제곱, cube : 세제곱

	prime divisor (or factor) : 소인수 (素數 인 인수), 예) 8 의 인수는 1, 2, 4, 8 이며 소수는 2 뿐이므로 2 가 8 의 소인수

	prime factorization : 소인수 분해, 소인수로 분해하기, 예) 30 = 2 x 3 x 5

	prime number : 소수 (素數, 바탕이 되는수), prime (첫째의, 근본적인), 다른 어떤수의 곱으로 표현되지 않는 근본적인 수

	prism : 각기둥, triangular prism : 삼각기둥

	probability : 확률, probable 은 '있음직한, 그러나 확실하지는 않은' 이라는 뜻이 있다.

	product : 곱

	proof : 증명, 증거를 들어 어떤 것이 참인지 거짓인지 판단하는 것, demonstration 이라고 하기도 한다.

	proper fraction : 진분수, 가분수와 구분되는 의미, 5/4 는 가분수

	proportion : 비례, inverse proportion : 반비례

	proportional distribution : 비례배분, 10 을 3 : 2 로 비례배분하면 각각 6 과 4 가 된다.

	proportional expression : 비례식, 비의 값이 같은 두 비를 등식으로 나타낸 것, 예) 2 : 3 = 4 : 6

	proportional factor (or constant) : 비례상수, 정비례 y = ax, 반비례 y = a/x 에서 상수 a 가 비례상수이다.

	proposition : 명제

	protractor : 각도기

	pyramid : 각뿔, truncated pyramid : 각뿔대

	Pythagorean theorem : 피타고라스의 정리, 직각삼각형의 직각을 낀 두 변의 길이가 a, b, 빗변 c 일 때 a2 + b2 = c2 이다.

	quadrangle : 사각형

	quadrant : 사분면, 1사분면 (first quadrant, x>0, y>0) ... 4사분면 (fourth quadrant, x>0, y<0)

	quadratic : 이차

	quadratic equation : 이차 방정식

	quadratic expression : 이차식

	quadratic function : 이차함수

	quotient : 몫

	qurdratic formula : (이차방정식) 근의 공식, quadratic equation : 이차방정식

	radical sign : 근호, root 와 같은 의미 √

	radius : 반지름

	radius : 반지름, '수레바퀴의 살' 이라는 뜻이 있다.

	range : 치역, 함수에서 Y 의 범위

	rate : 비율

	ratio : 비, 견주다

	ratio of similarity : 닮음비, 닮음비가 1 이면 같은 도형

	ratio of the circumference of a circle to its diameter : 원주율, 원의 지름과 원둘레의 길이의 비율

	rational number : 유리수, 두 정수의 비로 나타낼 수 있는 수

	rationalization : 유리화 (유리수로 만들기), 근호가 있는 형태의 무리수를 같은 무리수를 곱해서 유리수로 만드는 것

	ray : 사선, 반직선, 빛이 뻗어나가는 선, 한 점에서 뻗어나가는 선

	real line : 실선, 실선의 직선 또는 실수의 직선

	real number : 실수, 실제로 존재하는 수

	rectangle : 직사각형, 평면도형의 내각이 모두 직각인 경우 접두사 直 을 사용

	rectangular parallelepiped : 직육면체, 육면체 중에서 면이 모두 직사각형 (rectangular) 인 것,

	rectangular prism : 사각기둥

	reduction of fraction : 약분 (약분수, 간략히 하다), 예) 분수 2/8 을 약분하면 1/4

	reduction to common denominator : 통분, 공통분모, 분수를 서로 통하게 하려고 분모를 같게 만드는 것

	regular polygon : 정다각형, 평면도형의 각 선분의 길이가 같고 내각의 크기가 모두 같을 때 접두사 '正' 을 사용한다.

	regular polyhedron : 정다면체, 입체도형의 각 면의 모양이 합동인 도형일 때 접두사 '正' 을 사용한다.

	regular triangle : 정삼각형 (equiangular triangle)

	relation : 관계, expression of relation : 관계식

	relative frequency : 다른 것과 비교해서 나타낸 도수

	relatively prime : 서로소 (서로에 대한 소수), 2 와 3, 9 와 10 과 같이 공약수가 1 뿐인 두 자연수

	remainder : 나머지

	repeating (or periodic, recurring) decimal : 순환소수

	representative value : 대표값, 예) 평균은 대표값의 하나이다.

	rhombus : 마름모

	right angle : 직각

	right triangle : 직각삼각형, right angled triangle

	root : 근, 해 (resolution)

	rounding (to the nearest whole number) : 반올림

	rounding off : 아래 자리의 수를 버림,

	rounding up : 아래 자리의 수를 올림,

	ruler : 자, rule 에는 '선을그리다' 라는 뜻이 있다.

	scale : 눈금

	secant line : 할선, 원과 두점에서 만나는 직선이 원을 둘로 나누는 것처럼 보이기 때문에 할선이라 한다.

	section paper : 모눈종이

	sector : 부채꼴

	segment (of a circle) : 활꼴 (cresent : 초승달), 원의 호와 그 두끝을 연결하는 선분으로 이루어지는 평면도형

	set : 집합

	set builder form : 조건 제시법, 집합을 나타낼 때 각 원소를 나열하는 대신 공통성질을 제시하는 방법

	significant digit : 유효숫자, 근사값을 나타내는 숫자 가운데 믿을 수 있는 숫자

	similar terms : 동류항, 같은 무리에 속하는 항, 예) 3x 와 2x

	similarity : 닮음, 두 도형의 닮음인 관계

	simultaneity : 연립

	simultaneous equations : 연립방정식

	simultaneous inequalities : 연립부등식, 두 개 이상의 부등식을 함께 묶어 한쌍으로 나타낸 것

	sine : 직각삼각형의 빗변 을 높이로 나눈 것

	skew point : 꼬인 위치, 두 직선이 서로 만나지도 않고, 평행하지도 않은채 비스듬히 (skew) 위치함

	slope : 기울기, 경사지다, gradient (도로나 철도의 기울기) 와 같은 의미

	solid : 입체, 원래의 뜻인 고체는 입체적이므로,

	solid figure : 입체도형, 예) 정사면체, 회전체 등과 같이 "~체" 로 끝나는 것은 입체도형이다.

	solution : 해, 근

	sphere : 구

	square : 정사각형 (regular quadrilateral), '네모로 만들다', 제곱

	square : 제곱

	square meter : 제곱미터

	square root : 제곱근, 평방근, 제곱근표 (table of square roots)

	statistics : 통계, '합해서 셈하다 또는 합해 놓은 수'

	stem and leaf plot : 줄기와 잎 그림, 자료 57, 53, 68 이 있을 때 50, 60 이 줄기, 7, 3, 8 이 잎

	straight angle : 평각, '구부러지지 않고 쭉 펴 있는 각'

	straight line : 직선

	subset : 부분집합

	substitution : 대입, 예) 수를 문자에 대입

	subtraction : 뺄셈, 5 - 3 = 2에서 5 는 피감수 (minuend), 3 은 감수 (subtrand)

	sum : (덧셈에서의) 합

	surface : 곡면,

	surface area : 겉넓이, 넓이

	symmetric figure for a line : 선대칭도형

	symmetric figure for a point : 점대칭 도형

	symmetric transposition : 대칭이동

	symmetry : 대칭

	table : 표, '전체를 한눈에 쉽게 볼 수 있도록 어떤 사항들을 일정한 순서에 따라 벌여 적은 것'

	table of square roots : 제곱근 표

	tabular form : 원소나열법, 예) {1, 2, 3, .....}

	tangent : 접선, 접하다, tangens (접촉하다), 원 O 의 외부의 한점 P에서 이 원에 그을 수 있는 접선은 두 개

	tangent : 탄젠트, 접촉, '해시계 바늘의 그림자' 를 의미, 그림자의 길이는 바늘의 길이를 반지름으로 하는 원의 접선의 일부.

	tangent point 또는 point of tangency : 접점

	tangram : 칠교판, '일곱 조각으로 이루어진 재주 부리는 판'

	term : 항, 예) 2x - 4x2 에서 2x, -4x2 이 항이다.

	theorem : 정리, 참이라고 증명된 명제

	transposition : 이항, 등식에서 등호의 왼쪽 또는 오른쪽의 항을 부호를 바꾸어 다른쪽으로 옮기다.

	trapezoid : 사다리꼴, isosceles trapezoid : 등변사다리꼴

	triangle : 삼각형

	triangular prism : 각기둥

	trigonometric ratio : 삼각비, sin A, cos A, tan A 를 각 A 의 삼각비 라고 한다. (trigon 은 triangle 과 같은 의미)

	truncated cone : 원뿔대

	truth value : 참값, 진가

	union : 합집합, sum of sets, 두 개 이상의 집합의 원소 모두로 된 새로운 집합

	unit : 단위

	unit fraction : 단위분수, 분자가 1 인 분수

	universal set : 전체집합

	unknown : 미지수, 2x = 4 에서 x 는 미지수, unknown number 를 간단히 한 것

	unknown term : 미지항, or unknown quantity

	value of function : 함수값, 함수 y = f(x)에서 x=3 일 때 y=5 이면 5 가 함수값이다. 치역은 함수값 전체의 집합을 뜻한다.

	variable : 변수

	variate : 변량, 변수가 "수" 를 값으로 취하는 반면, 변량은 "양" 을 값으로 취한다.

	Venn diagram : 벤 다이아그램

	vertex : 꼭지점

	vertex angle : 꼭지각

	volume : 부피, 체적

	weight : (중력가속도를 감안한)무게, mass : 질량 (중력가속도를 감안하지 않은 무게), 수학에서의 무게는 질량을 의미

	width : 가로



	absolute value : 절대값
	acute angle : 예각
	acute triangle  : 예각 삼각형
	adjacent angle : 인접각/이웃각
	adjacent arc : 인접호
	alternate exterior angles 엇각중에서 외각 : 우리나라에서는 이것을 엇각으로 부르지 않는다
	alternate interior angles :엇각(exterior , interior 강의 참조)
	Altitude : 높이
	angle bisector : 각의 이등분선
	Approximate : 약, 대략
	Area : 넓이
	Arithmetic : 산수
	ascending order of power : 오름차순(낮은 것부터)<->descending order
	Average : 평균
	Axes: 축
	
	B

	bar graph : 막대그래프
	base(in numeration) : 지수가 있는 수에서 밑
	base(or a polygon or three-dimensional figure) : 밑변 (다각형 또는 입체도형의)
	Bisect : 이등분



	C

	Calculator : 계산기
	Capacity : 용량
	Center : 중심
	center angle : 중심각
	Chord : 현
	Circle : 원
	Circumference : 원주
	circumscribed circle : 외접원
	Clockwise : 시계방향
	Coefficient : 계수
	Combination : 조합
	common denominator : 공통분모
	common difference : 공차
	common factor : 공약수
	common multiple : 공배수
	common ratio : 공비
	complementary angle : 여각
	compound interest : 복리
	Conclusion : 결론
	conditional equation : 조건등식
	Cone : 원뿔
	Congruent : 합동
	consecutive even(odd) integers : 연속적인 짝수 (홀수)
	Constant : 상수
	Converse : 역
	Coordinate : 좌표
	coordinate axis : 좌표축
	coordinate plane : 좌표평면
	Correspondence : 대응
	correspondence angle (for lines) : 동위각
	correspondence angle (of polygon) : 대응각
	Cosine : 코사인
	Counter clockwise : 반 시계방향
	Counterexample : 반증, 반례
	Cube : 세제곱, 정육면체
	Cylinder : 원기둥




	D

	Decimal : 소수의, 십진법의
	Definition : 뜻, 정의
	Degree : 도, 차수
	degree of polynomial : 다항식의 차수
	Denominator : 분모
	Density : 밀도
	Diagonal : 대각선의
	Diameter : 지름
	Difference : 차, 나머지
	difference of squares : 두 완전제곱수의 차
	Dimension : 치수: 주어진 도형의 길이, 너비, 높이
	distance between two parallel lines : 평행한 두 선 사이의 거리
	Division : 나눗셈
	Domain : 정의 역
	
	E

	Edge : 모서리 
	Element : 원소
	Elimination : 소거
	Equality : 등식
	Equation : 방정식
	equilateral triangle : 정삼각형
	Equivalent : 동치
	Estimate : 어림잡다
	Evaluate : 값을 구하다
	even numbers : 짝수
	Exponent : 지수
	exponential function : 지수함수
	Extrapolation : 외삽법 : 모르는 값을 알려진 값으로부터 추정 또는 예측하는 방법
	extreme values : 극 값



	F

	Face : 면
	Factor : 인수
	Factoring : 인수분해
	Fraction : 분수
	Frequency : 도수, 빈도
	Function : 함수



	G

	GCF(Greatest common factor) : 최대공약수
	geometric mean : 기하평균
	geometric probability : 기하확률
	Geometry : 기하학



	H

	Height : 높이, 키
	Hemisphere : 반구
	Heptagon : 칠각형
	Hexagon : 육각형
	Histogram : 히스토그램
	Hypotenuse : 빗변
	Hypothesis : 가정



	I

	Identify : 지적하다. 알아내다
	improper fraction : 가분수
	independent ( systems of equations) : 일반적 연립방정식
	Index : 지수
	Inequality : 부등식
	Insert : 대입하다
	Integers : 정수
	Intercept : 절편
	Interest : 이자
	intersection (sets) : 교집합
	Interval : 구간
	Inverse : 역원
	Involving : 포함하는
	isosceles trapezoid : 등변사다리꼴
	isosceles triangle : 이등변삼각형
	
	L

	line symmetry : 선대칭
	linear equation : 일차방정식
	linear function : 일차함수



	M

	Matrix : 매트릭스 (행렬)
	maximum ( point of function) : 이차함수의 최대
	Mean : 평균
	Measurement : 측정(값)
	Median : 중선
	Midpoint : 중점
	minimum (point of function) : 이차함수의 최소
	Minus : 뺄셈
	mixed number : 대분수
	Mode : 최빈값 (모드)
	Monomial : 단항식
	Multiple : 배수





	N

	natural number : 자연수
	negative number : 음수
	nonlinear function : 비선형함수: 그래프가 직선이 아닌 함수
	number line : 수직선
	Numerator : 분자



	O

	obtuse angle : 둔각
	Octagon : 팔각형
	odd numbers : 홀수
	Omit : 생략하다
	Opposites : 덧셈에 대한 역원
	ordered pair : 순서쌍
	Origin : 원점
	Overestimate : 과대추정값 :  실제의 답보다 큰 추정값



	P

	Parabola : 포물선
	parallel lines : 평행선
	Parallelogram : 평행사변형
	Pentagon : 오각형
	Percent : 백분율 (%)
	perfect square : 완전제곱
	Perimeter : 둘레
	Permutation : 순열
	perpendicular bisector : 수직이등분선
	perpendicular lines : 수(직)선
	Plane : 평면
	Polygon : 다각형
	Positive : 양수의
	prime number : 소수
	Probability : 확률
	Product : 곱
	Proof : 증명
	Proportion : 비례
	Pyramid : 각뿔
	Pythagorean theorem : 피타고라스 정리



	R

	Radius : 반지름
	Range : 치역, 범위
	Rate : 속도, 비율
	Ratio : 비율
	rational number : 유리수
	real number : 실수
	Rectangle : 직사각형
	Remainder : 나머지
	Rhombus : 마름모
	right angle : 직각
	right circular cone : 직원뿔
	Rise : 수직변화 : 직선의 기울기가 (y의 변화량/x의 변화량)일 때, 분자인 y의 변화량
	Roots : 근, 해
	Rounding : 반올림
	Run : 수평변화 : 직선의 기울기가 (y의 변화량/x의 변화량)일때, 분모인 x의 변화량


	S

	Segment : 선분
	Similar : 닮은꼴
	sides of the equation : 방정식의 변
	significant digits : 유효숫자
	simple interest : 단리
	Simplify : 약분
	Sine : 사인
	Skew lines:꼬인 위치에 있는 선 (서로다른 평면)
	slant height : 경사높이 : 원뿔의 밑면에서 옆면을 따라 꼭지점까지 잰 거리
	Slope : 기울기
	Solution : 해, 답
	Sphere : 구
	Square : 제곱, 정사각형
	Statistics : 통계
	straight angle : 평각
	Subset : 부분집합
	Substitution : 치환
	Sum : 합
	supplementary angles : 보각
	surface area : 겉넓이
	Symmetry : 대칭



	T

	Tangent : 탄젠트
	Term : 항
	Theorem : 정리
	Times : 곱하기
	Total : 합계
	Transformation : 변환: 도형의 크기 또는 위치의 변화
	Trapezoid : 사다리꼴
	Trial : 시행
	Triangle : 삼각형
	trigonometric ratio : 삼각비
	
	U

	unit price : 단가



	V

	Value : 값, 수치
	Variable : 문자 (변수)
	Venn diagrams : 벤 다이어그램
	Vertex : 꼭지점
	vertex angles : 꼭지각
	vertical axis : 수직 축
	Volume : 부피



	W

	Weight : 무게
	whole number : 자연수
	Width : 가로



	X

	x-axis : x축
	x-coordinate : x좌표
	x-intercept : x절편



	Y

	y-axis : y축
	y-coordinate : y좌표
	y-intercept : y절편



	Z

	z-axis : z축
	zeros (of a function) : 함수를 0으로 만드는 값

	 

	 

	Absolute value, 절대값

	 Acute angle, 예각

	 Acute triangle, 예각 삼각형

	 Addition property for inequality,부등식 덧셈법칙

	 Addition property of equality,등식의 덧셈법칙

	 Addition –or subtraction method, 가감법

	 Adjacent angle, 접각

	 Adjacent arcs, 접호

	 Algebraic expression(Arithmetic) mean, 산술평균

	 Ascending order of power, 오름차순

	 Associative properties(axioms), 결합법칙

	 Auxiliary line, 보조선

	 Average, 평균

	 Axes, 좌표축

	 Axioms, 원리,공리



	 

	 -------------------------------------------------

	 Bar graph, 막대그래프

	 Base, 밑변

	 Base angles of an isosceles triangle, 이등변삼각형의 밑각

	 Base of an isosceles triangle 이등변 삼각형밑변(base)

	 Between 사이

	 Between and inclusive,같거나 크다,같거나 작다

	 Boundary(of half-plane), 경계선

	 Braces, 중괄호

	 Brackets, 대괄호

	 Broken line graph, 꺽은선 그래프

	 -------------------------------------------------

	 Calculator, 계산기

	 Celsius temperature scale, 섭씨온도계

	 Center of a circle, 중점

	 Center of a regular polygon,정다각형의 중점

	 Center of a sphere, 구의 중점

	 Chart, 표 차트

	 Chord, 현

	 Circle, 원

	 Circle graph, 원 그래프

	 Circumference, 원주

	 Circumscribed circle, 외접원

	 Coefficient, 계수

	 Common factor, 공약수

	 Common multiple, 공배수

	 Commutative property, 교환법칙

	 Comparison property, 교환법칙

	 Complementary angles, 보각

	 Composite number, 합성수

	 Compound interest, 복리

	 Concentric, 중심이 같은

	 Concentric circles, 동심원

	 Conclusion, 결론

	 Conditional, 조건문

	 Conditional, 조건명제

	 Conditional equation, 조건등식

	 Cone, 원뿔

	 Conjecture 추측

	 Consecutive even integers 연속적인 짝수

	 Consecutive integers 연속적인 정수

	 Consecutive odd integer 연속적인 홀수

	 Consequent 후항

	 Constant 상수

	 Constant of variation 계수

	 Converse 역

	 Convex polygon 볼록다각형

	 Coordinates 좌표
	 
	 Coordinate axis 좌표축

	 Coordinate plane 좌표평면

	 Coordinates of a point 점의 좌표

	 Coordinate proof 좌표평면을 이용한 증명

	 Cosine 코사인

	 Cost 물건값 비용

	 Counterexample 반증, 반례

	 Cube 세제곱, 정육면체

	 Cubic 삼차

	 Cubic equation 삼차방정식

	 Cylinder 원기둥

	 -------------------------------------------------

	 Data 자료

	 Decagon 십각형

	 Decimal 소수의, 십진법의

	 Deductive reasoning 연역법

	 Definition 뜻, 정의

	 Degree 도, 차수

	 Degree of a polynomial 다항식의 차수

	 Denominator 분모

	 Density 밀도

	 Density property 두 유리수

	 Dependent variable 종속변수

	 Diagonal 대각선의

	 Diagrams 다이어그램(도표)

	 Diameter 지름

	 Difference 차, 나머지

	 Differences of squares 두 완전제곱수의 차

	 Discounting 디스카운트 (할인해 주는)

	 Distance between a point and a line 한 점과 선 사이의 거리

	 Distance between two parallel lines 평행한 두 선 사이의 거리

	 Distance formula 두 점 사이의 거리공식

	 Distributive property of multiplication 곱셈분배법칙

	 Divide 나누다

	 Dividing rational numbers 유리수의 나눗셈

	 Division 나눗셈

	 Division property for inequality부등식 분배법칙

	 Division property of equality 등식의 분배 법칙

	 Dodecagon 십이각형

	 Domain 정의역(번역)

	 -------------------------------------------------

	 Edge 모서리

	 Element 원소

	 Elimination 소거

	 Empty set 공집합

	 Equality 등식

	 Equally likely(outcomes) 결과(그 결과가 나올  확률이 동등할 때를 말함)

	 Equation 방정식

	 Equation in two variables 이원방정식

	 Equiangular triangle 정삼각형

	 Equidistant 같은 거리의(등거리의)

	 Equilateral triangle 정삼각형

	 Equivalent equation 답이 같은 방정식

	 Estimate 어림잡다

	 Evaluate 값을 구하다

	 Even numbers 짝수

	 Example 보기

	 Excluded value 극값

	 Exponent 지수

	 Exponential decay 감가상각

	 Exponential function 지수함수

	 Exponential growth 시간이 지남에 따라 원래보다 증가하는 것 (함수)

	 Expression(계승)

	 -------------------------------------------------

	 Factoring 인수분해

	 Fahrenheit temperature scale 화씨온도

	 Formula 공식

	 Fraction 분수

	 Fractional equation 분수식

	 Frequency 도수, 빈도

	 Frequency table 도수분포표

	 Function 함수

	 Functional notation 함수, 표기

	 -------------------------------------------------

	GCF(Greatest common factor) 최대공약수

	 Geometric mean 기하평균

	 Geometric probability 기하확률

	 Geometric sequence 등비수열

	 Geometry 기하학

	 Graph 그래프, 그래프를 그리다

	 Graphic method 그래프 사용푸는 방법(식)

	 Graph theory 그래프 이론

	 Graphing calculators그래픽캘큘레이터(계산기)

	 Great circle 반구의 면

	 Greater than symbol ‘~보다 크다’ 부호

	 Greater than or equal to symbol

	              ‘~보다 같거나 크다’를 나타내는 부호

	 -------------------------------------------------

	 Height 높이, 키

	 Hemisphere 반구

	 Heptagon 칠각형

	 Hexagon 육각형

	 Horizontal axis 수평축(X축)

	 Hypotenuse 빗변

	 Hypothesis 가정

	 -------------------------------------------------

	 If and only If 필요충분조건

	 Identify 지적하다, 알아내다

	 Identity 항등식

	 If-then statement 조건문

	 Illustrated 그림으로 나타난, 그림으로 설명된

	 Image 상

	 Inch 인치

	 Independent events 독립사건

	 Independent(systems of equations) 일반연립방정식

	 Independent variable (quantity) 독립변수

	 Index 지수

	 Inductive reasoning 귀납법

	 Inequalities 부등식

	 Inequality symbol 부등호

	 Insert 대입하다

	 Integers 정수

	 Intercept 절편

	 Interest 이자

	 Interior Angle Sum Theorem 내각의 합 정리

	 Interior angles 내각

	 Interquartile range 사분범위

	 Intersection 교집합

	 Interval 구간

	 Inverse 역원

	 Involving 포함하는

	 Irrational numbers 무리수

	 Isosceles trapezoid 등변사다리꼴

	 Isosceles triangle 이등변삼각형

	 Isosceles Triangle Theorem 이등변삼각형 정리

	 Iteration 반복

	 -------------------------------------------------

	 Law of Cosines 코사인법칙

	 Law of sines 사인법칙

	 Least common denominator 최소공분모(LCD)

	 Least common multiple(LCM) 최소공배수

	 Length 세로(길이)

	 Less than symbol '~보다 작다'를 나타내는 부호

	 Less than or equal to symbol 같거나 작다

	 Line 선

	 Line graph 선 그래프

	 Linear equation 일차방정식

	 Linear function 일차함수

	 Linear graphs 일차함수의 그래프

	 Locus 자취

	 Lower quartile 제1사분위

	 -------------------------------------------------

	 marked down 인하

	 Marked up 인상

	 Matrix 매트릭스(행렬)

	 Maximun (point of function) 이차함수의 최대

	 Mean 평균

	 Means 내항

	 Measurement 측정(값)

	 Median 중앙값(중간값)

	 Median 중선

	 Midpoint(of line segment) 중점

	 Midpoint formulas 중점공식

	 Minimum (point of function) 이차함수의 최소

	 Minus 뺄셈

	 Mode 최빈값(모드)

	 Multiple 배수

	 Multiplication 곱하기

	 Multiplicative property of equality 양변에 같은수를 곱해도 그 결과는 같다.  

	 -------------------------------------------------  

	 Natural numbers 자연수

	 Negation 부정

	 Negative correlation 음의 상관관계

	 Negative exponents 음의지수

	 Negative integer 음의 정수

	 Negative number 음수

	 Negative sign(-) 음수부호

	 Network 네트워크

	 Nickel 5센트

	 Nonagon 구각형

	 Not equal to symbol 같지 않다는 부호

	 Number line 수직선

	수선 <垂線,perpendicular>

	 Number theory 수이론

	 Numerals 숫자

	 Numerator 분자

	 Numerical coefficient 수계수

	 Numerical expression(원점)

	 -------------------------------------------------

	 Outcomes 결과

	 Outlier 아웃라이어

	 -------------------------------------------------

	 Parabola 포물선

	 Parallel lines 평행선

	 Parallel Postulate 평행정리

	 Parallelogram 평행사변형

	 Parallelogram law 평행사변형의 법칙

	 Parent graph 기본 그래프

	 Parentheses 소괄호

	 Penny 1센트

	 Pentagon 오각형

	 Percent 퍼센트(%)

	 Percent of decrease 몇 퍼센트 감소했는지

	 Percent of increase 몇 퍼센트 증가했는지

	 Percent proportion 퍼센트 비율

	 Percentage 퍼센티지

	 Perfect square 완전제곱

	 Perimeter 둘레

	 Perpendicular bisector 수직이등분선

	 Perpendicular bisector of a triangle 삼각형의 수직이등분선

	 Perpendicular lines 수(직)선

	 Perpendicular segment 수직인 선분

	 Pi 파이

	 Pint 파인트 (액체의 단위)

	 Plane 평면

	 Plane Euclidean geometry 유클리드기하학

	 Plane figure 평면도형

	 Platonic solid 플라톤의 입체

	 Point 점

	 Point of relection 중점

	 Point of symmetry 대칭점

	 Point of tangency 점점

	 Polygons 다각형

	 Polyhedron 다면체

	 Polynomial 다항식

	 Polynomial equation 다항방정식

	 Positive 양수의

	 Positive correlation 양의 삼관관계

	 Positive integer 양의정수

	 Positive sign (+)0보다 큰 수량 의미하는 부호

	 Positive numbe 양수

	 Postulate 공리

	 Power 거듭제곱

	 Prime factorization 소인수분해

	 Prime number 소수

	 Principal 자본

	 Principal square root 양의 제곱근

	 Prism 각기둥

	 Probability 확률

	 Problem-solving strategies(Plan) 응용문제푸는 법

	 Product 곱

	 Product of powers 거듭제곱수의 곱

	 Product property of square roots 제곱근곱셈법칙

	 Proof 증명

	 Proportion 비례

	 Protractor 각도기

	 Pyramid 각뿔

	 Pythagorean theorem 피타고라스 정리

	 Pythagorean triple 피타고라스의 수

	 -------------------------------------------------

	 Quadrant 사분면

	 Quadratic equation 이차방정식

	 Quadratic formula 근의 공식

	 Quadratic function 이차함수

	 Quadrilateral 사각형

	 Quart 쿼트(액체의 단위)

	 Question 질문

	 Questionnaire 질문지

	 Quotient 몫

	 Quatient of powers 거듭제곱수의 나눗셈

	 -------------------------------------------------

	 Radical equation 무리방정식

	 Radical expression(분수식)

	 Rational number 유리수

	 Ray 반직선

	 Real numbers 실수

	(유리수와무리수를 합한 수)

	 Reciprocal 곱셈에 대한 역원

	 Rectangle 직사각형

	 Rectangular solid 직육면체

	 Reflection 반사

	 Regular polygon 정다각형

	 Regular polyhedron 정다면체

	 Regular prism 정각기둥

	 Regular pyramid 정각뿔

	 Regular tessellation 정다각형의 배열

	 Relation 관계

	 Remainder 나머지

	 Remote interior angles 주어진 외각과 접해 있지 않은 두 내각

	 Rhombus 마름모

	 Right angle 직각

	 Right circular cone 직원뿔

	 Right cylinder 직기둥

	 Right prism 직각기둥

	 Right pyramid 직각뿔

	 Right triangle 직각삼각형

	 Rise Y축 방향

	 Roots 답, 근, 해

	 Rotation 회전

	 Round off 반올림

	 -------------------------------------------------

	 Sample space 표본공간

	 Sampling 표본조사

	 Scalar multiplication 행렬의 곱셈

	 Scale 스케일

	 Scalene triangle 부등변삼각형

	 Scatter plot graph 점그래프

	 Scientific notation 십진법의 표기법

	 Segment 선분

	 Semicircle 반원

	 Sequence 수열

	 Set 집합

	 Side 변

	 Sides of the equation 방정식의 변

	 Similar figures 닮은꼴

	 Similar polygons 닮은 다각형

	 Similar solids 닮은 입체

	 Similar triangles 닮은 삼각형

	 Simple interest 단리

	 Simplest form of expression(of linear equations)일차방정식의 일반형

	 Statistics 통계

	 Straight angle 평각

	 Straightedge 직선자

	 Strictly self-similar 위치,크기에 상관없이 부분이 전체와 같은 모양이 되는 것

	 Substitution 대입

	 Subtraction 뺄셈

	 Subtraction property for inequality 부등식의 뺄셈법칙

	 Subtraction property of equality 등식의 뺄셈법칙

	 Sum 합

	 Supplementary angles 보각

	 Surface area 겉넓이

	 Symmetric property of equality 등식의 양변을 바꾸어도 결과는 같다.

	 Symmetry 대칭

	 Systems of equations 연립방정식

	 Systems of inequality 연립부등식

	 -------------------------------------------------

	 Tables 표

	 Tangent 탄젠트

	 Tangent segment 접선

	 Term 항

	 Theorem 정리

	 Times 곱하기

	 Total 합계

	 Transformation 변환

	 Transitive property of equality 등식에서 a와 b가 같고, b와 c가 같으면

	    a와 c도 같다는 법칙

	 Translation 평행이동

	 Transversal 횡단선

	 Trapezoid 사다리꼴

	 Tree diagram 수형도

	 Triangle 삼각형

	 triangular cylinder 삼각기둥

	 Trigonometric ratios 삼각비

	 -------------------------------------------------

	 undefined term 무정의 용어

	 uniform 균등

	 Union 합집합

	 unit cost 단위 값

	 upper quartile 제 3사분위

	 -------------------------------------------------

	 Value 값, 수치

	 variable 문자(변수)

	 venn diagrams 벤다이어그램

	 verbal expression(of a function) 함수를 0으로 만드는 값

	 

	가감법: 연립방정식의 해법으로서 두 방정식의 양변에 적당한 수를 곱해서 두 식의 양변을 변변이 더하거나 빼어 한 개의 미지수를 소거한 다음 방정식을 푸는 방법이다.

	가정: 어떤 명제에서 조건을 의미한다.

	가평균: 어떤 자료의 평균을 임시로 어림잡은 값을 가평균이라 한다. 이 가평균과 원자료와의 편차를 고려하여 평균을 구하는 데 사용한다.

	 각(angle):한 점에서 두 사선에 의해 만들어진 도형으로, 종류로는 평각, 직각, 예각, 둔각, 동위각, 맞꼭지각, 엇각, 내각, 외각, 대각, 내대각, 중심각, 원주각 등이 있음.

	각뿔(pyramid): 뿔체 중에서 밑면이 다각형인 것

	각뿔대(frustum of pyramid): 각뿔을 밑면에 평행이고 꼭지점을 지나지 않는 평면으로 잘라 꼭 지점의 부분을 없앤 입체

	각의 꼭지점(vertex of angle): 각의 두 변의 교점

	각의 변(side of angle) : 각을 만드는 두 개의 사선

	각의 이등분선(bisection of angle) : 임의의 각을 2등분한 사선

	거듭제곱(power, repeated square): 어떤 수나 문자를 거듭하여 곱한 것

	결론: 명제 'p 이면 q이다.'에서 q를 의미하며 종결부분을 말한다.

	결합법칙(associative law): 결합률이라고도 하며 덧셈 곱셈에 대하여

	   x + ( y + z ) = (x + y ) + z
	   x(yz) = (xy)z    이 성립하는 것을 말함

	계급(class) : 도수분포표에서 자료의 측정 내용을 구간별로 나눈 것

	계급값 : 도수분포표에서 각 계급의 자료값

	계급의 크기(class interval): 도수분포표에서 계급의 구간 폭을 의미함

	계수(coefficient): 어떤 식에서 한 문자에 착안할 경우 그 문자의 이외의 수를 말함

	공배수(common multiple): 두 개 이상의 수에 공통된 배수를 말하고 이들 중 최소인 수를 최소공배수라 한다.
	
	공약수(common divisor): 두 개 이상의 수에 공통된 약수를 말하고 이들 중 최대인 수를 최대공약수라 한다. 공인수라고도 함.

	공역(codomain):  X에서 Y에로의 함수에서 Y의 값이 취할 수 있는 값의 영역

	공집합(empty set, null set): 원소가 하나도 없는 집합.  기호로는   {  }, Ф를 사용함

	공통내접선: 두 개의 원에 공통인 접선 중에서 그들의 두 개의 원이 이 접선의 양쪽에 있는 것을 말한다.

	공통외접선: 두 개의 원에 공통인 접선 중에서 그들의 두 개의 원이 이 접선의 같은 쪽에 있는 것 을 말한다.

	공통인수: 공통인자라고도 하며 다항식에 있어서 두 개 이상의 항에 공통인 인수를 그들 항의 공통인수라 한다.

	공통접선: 두 개의 원에 공통인 접선을 말한다.

	공통접선의 길이: 두 개의 원의 공통접선에서 두 접점간의 거리를 말한다.

	공통현: 두 개의 원에 공통인 현을 말한다.

	교각(angle of intersection): 두 직선 또는 두 곡선의 교각

	교선(line of intersection): 두 평면이 오직 한 직선을 공유할 때에 만난다라고 하며 그 직선을 두 평면의 교선이라고 한다.

	교점(point of intersection): 두 직선이 만나는 한 점

	교집합(intersection set): 집합 A와 집합 B의 어느 쪽에도 포함되는 원소 전체의 공통부분의 집합

	교환법칙(commutative law): 두 수 a, b에 대하여 a + b = b + a 가 성립하는 것을 말함

	구(sphere): 한 점으로부터 일정한 거리에 있는 공간의 점의 자취(공)이다.

	근(root): 방정식의 해 또는 해집합을 말한다.

	근사값: 참값을 반올림, 버림을 하여 얻거나, 어떤 측정에 의하여 얻은 측정값과 같이 참값대신 사용하는 참값에 가까운 값을 말한다.

	근의 공식: 방정식의 계수를 써서 그 근을 계산하기 위한 공식으로 2차방정식의 근의 공식이 있다.

	근호: 근의 기호, 루트(root)라고도 하며 수의 거듭제곱근을 표시하는데 사용한다.

	기대값: 불확실한 현상에 대한 기대되는 값으로, 어떤 변량에 그 변량의 확률을 곱하여 더한 값을 말한다.

	기울기: 경사라고도 하며 x 의 증가에 대한 y의 증가의 비율을 말한다.

	꼬인 위치: 공간에서 두 직선이 만나지도 평행하지도 않은 위치

	꼭지점: 두 선분의 교점이나 3개이상의 모서리의 공통된 끝점을 말함


	내각(internal angle): 다각형의 꼭지점에서 두 변이 만드는 각 중 도형의 내부에 있는 각

	내대각: 다각형에서 한 꼭지점에서의 외각과 접하고 있지 않은 내각들을 그의 내대각이라고 한다.

	내심: 삼각형의 내접원의 중심을 말한다.

	내접다각형: 모든 꼭지점이 원주 위에 있는 다각형을 말한다.

	내접원: 어떤 도형에 내접하는 원을 말한다.

	누적도수(cumulative frequency): 도수분포표에서 각 계급의 도수를 더하여 누적해 가는 도수

	 

	다각형(polygon): 한 평면 위에서 3개이상의 선분으로 닫힌 도형

	다면체(polyhedron): 몇 개의 평면으로 둘러싸인 입체

	다항식(polynomial): 두 개 이상의 단항식들이 대수적으로 합해져 있는 식

	단일폐곡선(simple closed curve): 단일 연속곡선의 양끝이 일치하고 있는 곡선

	단항식(monomial): 숫자와 몇 개의 문자의 곱만으로 구성되어 있는 식

	닮음: 두 도형을 이동하거나 확대 축소하여 서로 겹치게 할 수 있을 때 닮았다고 한다.

	닮음의 위치: 두 개의 도형 위의 점들이 1:1 대응이 만들어지고 그 대응하는 점을 잇는 직선이 모 두 한점 O에서 만나 그것이 O에 의하여 모두 같은 비로 내분되거나 외분되어 있을 때 이를 닮음의 위치에 있다라고 한다.

	닮음의 중심: 두 도형이 닮음의 위치에 있을 때 이 중심 O를 말한다.

	대각선(diagonal): 다각형에서 이웃하지 않는 꼭지점을 잇는 선분

	대변(opposite side): 삼각형의 한 꼭지점에서 이웃하지 않는 변 혹은 사각형의 한 변에서 이웃하지 않는 변을 의미함

	대응(correspondence): 한 집합의 임의의 원소에 대하여 다른 집합의 임의의 원소를 생각하는 하나의 규칙을 의미함
	
	대입(substitution): 식 또는 함수에 있어서 그 안에 포함되는 문자나 변수를 그것과 같은 다른 것 으로 바꾸어 놓는 것

	대입법: 연립방정식을 풀 경우, 한 식에서 한 미지수를 다른 미지수로 정돈 표현하여 그것을 다른 식에 대입하여 하나의, 미지수를 소거하는 방법을 말한다.

	대표값: 자료의 특징이나 경향을 가리키는 하나의 수의 값을 말하며, 종류로는 평균, 중위수, 최빈값 등이 있다.

	도수(frequency): 도수분포표에서 각 계급에 나타나는 자료의 개수

	도수분포다각형(frequency polygon): 도수분포표를 히스토그램으로 옮겼을 경우 이 기둥의 각 정 점을 이은 도수꺾은선을 말한다.

	도수분포표(frequency table): 각 계급에 각각의 도수를 기록한 표

	동류항(like term, similar terms): 수계수 이외의 문자인수가 모두 같은 단항식을 말한다.

	동심원: 같은 중심을 가지고 반지름의 크기가 다른 원을 말한다.

	동위각(corresponding angle): 두 직선에 다른 한 직선이 만나서 이루는 같은 위치의 각을 말함

	둔각(obtuse angle): 직각보다 크고 180도보다 작은 각을 말한다.

	등식: 양변에 각 항들을 등호로 연결한 식


	맞꼭지각(vertically opposite angle): 두 직선이 한 점에서 만날 때 서로 이웃하지 않는 각을 말한 다.

	명제: 거짓과 참을 구분할 수 있는 문장이나 식을 말한다.

	모선(generator): 기둥면을 이루는 하나의 모서리의 직선을 말한다.

	뫼비우스띠(Mobius band): 긴 직사각형을 한 번 비꼬아서 대변을 서로 맞붙인 도형으로 안과 밖을 구분할 수 없는 도형이다.

	무게중심: 삼각형에서 세 중선의 교점을 말한다.

	무리수: 실수 중에서 유리수가 아닌 수를 무리수라고 하며 이는 순환하지 않는 무한소수이다.

	무한소수: 소수점아래 한없이 유효숫자가 계속되는 소수를 말한다.

	무한집합(infinite set): 한 집합에 속한 원소의 개수가 무한개인 집합

	미지수: 아직 결정되지 않은 수 혹은 아직 구체적인 값이 안 알려진 수

	밑: 거듭 제곱수에서 지수 밑에 쓰여진 수


	반직선(half line): 한 직선을 한 점에 의해 두 개로 나눌 때 그 점을 포함하지 않는 양쪽부분을 각각 반직선이라고 한다.

	방심: 삼각형의 한 내각의 2등분선과 두 외각의 2등분선이 만나는 점을 방심이라고 한다.

	방정식(equation): 등식에서 한 문자에 어떤 특정한 값을 대입할 때에 한하여 등식이 성립하는 식

	배수(multiple): 어떤 수의 정수배를 배수라 한다.

	부등식: 수학의 식이 등호가 아닌 부등호로 연결되어 있는 식

	분모유리화: 분모에 근호를 포함하고 있는 식이나 수를 분모에 근호가 없는 식으로 변환하는 것

	분산(variance): 각 변량이 평균으로부터 떨어져 있는 거리의 제곱의 합을 총 도수로 나눈 값


	사건(event): 확률실험에서 한 시행의 결과에 의해 발생하는 일

	사인: 삼각함수와 삼각비의 하나로 직각삼각형에서의 높이/빗변을 의미한다.

	산포도: 자료가 흩어져 있는 정도를 말한다.

	삼각비: 직각삼각형에서 두 변의 비를 각각 말하는 것으로 사인은 높이/빗변, 코사인은 밑변/빗변, 탄젠트는 높이/밑변의 비의 값을 의미한다.

	상관관계: 두 변수사이에 관계를 말하는 것으로 한 쪽이 증가할 때 다른 쪽도 증가하면 양의 상관 관계, 한 쪽이 증가할 때 다른 쪽도 감소하면 음의 상관관계가 있다고 한다..

	상관도: 두 변수 사이의 관계를 그림으로 나타낸 것

	상관표: 두 변수를 수평축과 수직축을 기준으로 구분하여 각 개체를 나타낸 표를 말한다.

	상대도수(relative frequency): 각 계급의 도수를 전체도수로 나눈 비율을 말한다.

	상수항(constant term): 미지수를 포함하고 있지 않는 항

	서로소(relatively prime): 두 정수 사이에 1 이외의 공약수가 없을 때를 서로소라 한다.

	선분(segment): 직선위에서 그 위의 두 점사이에 한정된 직선의 한 부분

	소거: 연립방정식에서 어떤 문자를 다른 미지수로 표현하여 그 문자를 없애는 방법이다.

	소수(prime number): 1이 아닌 자연수 중에서 1과 그 수 자신만을 약수로 갖는 자연수

	소인수(prime factor): 어떤 자연수의 약수를 인수라 하며 이 인수 중에서 소수인 수

	소인수분해(factorization in prime factors): 합성수를 그의 소수들의 곱으로 나타내는 것

	수선(perpendicular): 어떤 일정한 직선 또는 평면에 수직인 직선

	수선의 발(foot of perpendicular): 직선 또는 평면에 수직인 직선이 직선 도는 평면과 만나는 점

	수심: 삼각형의 각 꼭지점에서 대변에 내린 수선의 교점을 말한다.

	수직(perpendicularity): 두 도형의 위치관계를 나타내는 용어로서 두 도형이 서로 직교하는 경우를 말하며 여기에는 직선과 직선, 직선과 평면, 평면과 평면의 직교함을 말한다.

	수직이등분선(perpendicular at midpoint): 주어진 선분의 중점에서 그 선분에 수직인 선

	순서쌍(ordered pair): 순서가 정해진 두 원소의 쌍 (a,b)를 말함

	순환마디: 순환소수에서 반복되는 숫자의 열을 순환마디라 한다.

	순환소수: 무한소수로서 소수점이하의 일정한 숫자열이 계속 반복되는 소수를 말한다.

	식의 값(numerical value of expression): 일정한 식의 문자에 수치를 대입하여 얻은 값

	실수: 유리수와 무리수를 합하여 실수라 부른다.

	십진법(decimal system): 10개씩을 모아 한 자리씩을 윗자리로 올라가게 하는 수의 표기법

	쌍곡선(hyperbola): 두 정점으로부터의 거리의 차가 일정한 점의 자취


	약수(divisor): 어떤 수를 나누었을 때 나누어 떨어지게 하는 수

	양변(both sides): 등식 또는 부등식에 있어서 왼쪽 변과 오른쪽 변을 모두 일컫는 말

	양수(positive number): 0 보다 큰 수를 의미한다.

	양의 상관관계: 두 변수사이에 관계에서 한 쪽이 증가할 때 다른 쪽도 증가하는 경우를 말함

	양의 유리수: 유리수 중에서 양수인 집합

	양의 정수: 정수 중에서 양수인 집합

	엇각(alternate interior angles): 어떤 두 직선에 한 직선이 만날 때 두 직선에 의한 내부각 중에 서로 엇갈려 있는 두각을 엇각이라 한다.

	여집합(complement): 전체집합과 그 부분집합이 있을 때 이 부분집합에 속하지 않는 원소들로 구 성된 집합

	역(converse): 조건문 'p 이면 q이다'에서 가정과 결론을 바꾸어 ' q이면 p이다' 라고 할 때 이를 역이라 한다.

	역수(invers number): 1을 어떤 수 a로 나누어 얻은 수, 즉 1/a

	연립방정식: 몇 개의 등식을 짝으로 한 방정식

	연립부등식: 몇 개의 부등식으로 짝을 이룬 부등식

	연립일차방정식: 연립방정식에서 그 속의 방정식의 차수가 가장 높은 것이 1차인 것을 말한다.

	예각(acute angle): 0도와 90도 사이의 각의 크기를 말한다.

	오진법(quinary): 수 0,1,2,3,4를 사용하여 5씩을 정리하여 한자리씩 윗자리로 올리는 표시방법

	오차의 한계: 오차의 범위를 말하는 것으로 참값으로부터의 측정값이 얻어지는 범위를 정한 것

	오차: 측정값과 참값의 차이를 말한다.

	완전제곱식: 어떤 식이 다른 식의 제곱꼴로 완전히 표시 될 때 이를 완전제곱식이라 한다.

	외각(external angle): 다각형에서 하나의 변과 그것에 이웃하는 변의 연장과 이루는 다각형의 외부의 각

	외심: 삼각형의 외접원의 중심을 말한다.

	외접다각형: 각 변이 한 원에 접하고 있는 다각형

	외접: 다각형의 모든 꼭지점이 하나의 원 주위에 있을 때 이를 원이 외접한다고 한다.

	외접원: 다각형의 모든 꼭지점이 한 원 주위에 있을 때 이 원을 외접원이라고 한다.

	우변(right side): 등식 또는 부등식에서 등호나 부등호의 오른쪽에 있는 변

	원(circle): 평면 위에서 한 점으로부터 일정한 거리에 있는 점들의 모임

	원뿔(circular cone): 평면 위의 한 곡선 a를 택하여 평면 위에 없는 한 점 b와 곡선 a위의 모든 점을 이은 직선에 의해 만들어지는 곡면을 뿔면이라고 하고 특히 평면 위의 곡선이 원이면 원뿔이라고 한다.

	원뿔대(circular truncated cone): 원뿔을 밑면에 평행인 평면으로 자르고 꼭지점을 포함하는 부분을 없앤 공간도형을 말한다.

	원소(element): 요소라고도 하며, 집합을 구성하고 있는 각각의 사물들을 원소라고 한다.

	원소나열법: 집합을 표시하는데 원소를 일일이 나열하여 표시하는 방법

	원점(origin): 직선 상에서 좌표를 정하는 기준이 되는 점

	원주(circumference): 원의 둘레를 의미함

	원주각: 원주상의 한점을 꼭지점이라고 하고 그 원의 두 개의 현을 변으로 하는 각을 말한다.

	유리수(rational number): 두 개의 정수 a, 0이 아닌 b를 취하여 분수 a/b의 꼴로 나타내어 지는 수

	유한소수: 무한소수에 대해 소수점이하에 유한 개의 수가 있는 소수

	유한집합(finite set): 원소의 수가 유한 개로 이루어지는 집합

	유효숫자: 근사값이나 측정값의 윗자리에서 의미가 있는 숫자를 말한다.

	음수(negative number): 0보다 작은 수

	음의 상관관계: 두 변수사이에 관계에서 한 쪽이 증가할 때 다른 쪽은 감소하는 경우를 말함

	음의 유리수: 유리수 중에서 음수인 수

	음의 정수(negative integer): 음의 정수 -1, -2, -3, ....을 말하는 정수 중에 음수를 말함

	이진법(binary notation): 숫자 0, 1만을 사용하여 2개씩을 묶어서 윗자리로 올리는 표기법이다.

	이차방정식: 방정식에서 차수가 2차인 식을 말한다.

	이차함수: 2차식으로 표현되는 함수를 말한다. y=ax^2 + bx + c 꼴임

	이항(transposition of terms): 등식이나 부등식에서 항의 부호를 바꾸면서 이동시키는 것

	인수분해: 수를 소수의 곱으로 표시하면 이는 유일하게 표시되고 이를 소인수분해라고 한다. 또한 정식에서는 한 식이 두 개이상의 식의 곱으로 나타낼 경우 이를 인수분해라고 하는데 더 이상 인수로 분해할 수 없을 때까지의 곱의 형태를 취한다.

	인수: 어떤 수나 식이 다른 수나 식들의 곱으로 표시 될 때 이들을 인수라 한다.

	일차방정식(linear equation): 정리하여 미지수에 대한 1차식만을 포함하는 방정식을 말한다.

	일차부등식: 최고 차수의 항이 1차인 부등식을 말한다.

	일차식(linear expression): 차수가 1차인 항을 말한다.

	일차함수: 차수가 1차인 함수를 말하며 y=ax +b형태를 취한다.

	작도(construction): 일반적으로 어떤 조건에 맞는 도형을 그리는 일을 말하며, 기하학에서는 자와 컴퍼스만을 사용하여 도형을 그리는 일을 말한다.

	전개: 다항식과 단항식들의 곱의 형태로 되어있는 식을 모두 곱하여 단항식의 대수적 합의 형태를 취하도록 하는 행동

	전개식: 다항식과 단항식들의 곱의 형태로 되어있는 식을 모두 곱하여 단항식의 대수적 합의 형 태로 만든 식

	전체집합(universal set): 하나의 집합을 정하고 이 집합의 부분집합을 고찰하는 대상으로 할 경우 이 원래의 집합을 전체집합이라고 한다.

	절대값(absolute value): 양, 음의 수의 부호를 없앤 수로 양수와 0은 그 수 자신이며 음수는 부호를 없앤 수이다.

	절편: 한 직선이 좌표축과 만나서 축을 자르게 되는 점을 절편이라고 한다. 예로 x절편, y절편

	접선(tangent line): 원과 직선이 두 점에서 만나면 할선, 한 점에서 만나면 이 직선을 접선이라 한다.

	접선의 길이: 원 밖의 한 점에서 접선을 그은 경우 한 점에서 접점까지의 길이를 말한다.

	접점(point of contact): 곡선 또는 곡면의 접선 또는 접평면이 그 곡선 또는 곡면과 접하는 점 을 말한다.

	정다각형(regular polygon): 변의 길이가 모두 같고 각의 크기도 모두 같은 다각형을 말한다.

	정다면체(regular polyhedron): 다면체중에서 면이 모두 합동인 정다각형으로 되어 있고 어느 꼭지점에서도 모이는 면의 수가 같고 입체각도 같은 것을 말한다.

	정리(theorem): 수학적 논증의 결과 옳다는 것이 증명된 사항 중 중요한 것을 말한다.

	정수(integer): 자연수, 0, 음의 정수를 합쳐서 정수라 한다.

	정의(definition): 수학에서 사용하는 용어의 뜻을 정확히 일의적으로 규정한 문장이나 식.

	정의역(domain of definition): 함수가 X에서 Y에로의 함수 일 때 X의 영역을 말함

	제곱근: 제곱하여 a 가 되는 수를 a의 제곱근이라 한다.

	조건제시법: 집합을 표시할 때 원소의 조건을 제시하는 방법

	좌변(left side): 등식 또는 부등식에서 등호나 부등호의 왼쪽에 있는 변

	좌표(coordinates): 수직선상의 원점을 기준으로 단위길이를 정한다음 임의 점 p에 대하여 그 매겨진 수를 점 P의 좌표라고 한다.

	좌표축(coordinates axis): 직교좌표계 또는 사교좌표계 O-xy에서 수직선 Ox와 Oy를 각각 x 축, y축이라 하고 이 둘을 합쳐 좌표축이라고 한다.

	좌표평면(coordinate plane): 공간의 직교좌표계 O-xyz 에 대하여 x축과 y축을 포함하는 평면을 xy평면 , y축과 z축을 포함하는 평면을 yz평면 , z축과 x축을 포함하는 평면을 zx평면이라고 하고 이들을 총칭하여 좌표평면이라고 한다.

	중근: 2차방정식에서 판별식 D=0일 때 갖게되는 두 근이 중복된 경우의 근을 중근이라 한다.

	중선: 삼각형의 꼭지점과 그 대변의 중점을 연결하는 선분을 그 삼각형의 중선이라 한다.

	중심각(central angle): 중심이 O인 원의 호 AB에 대하여 각 AOB를 호 AB에 대한 중심각이라고 한다. 중심각은 같은 호에 대한 원주각의 두배이다.

	중심거리: 두 원의 중심사이의 거리를 말한다.

	중심선: 두 원의 중심을 연결한 직선을 말한다.

	중점(middle point): 2등분점이라고 하며, 선분 위의 양 끝점에서 같은 거리에 있는 점을 말한 다.

	중점연결의 정리: 삼각형의 두 변의 중점을 잇는 선분은 제 3의 변에 평행이고 길이는 그 절반과 같다.

	증명: 논증이라고도 하며 참이라고 인정되는 몇 개의 명제로부터 유효한 추론에 의해 다른 명제가 참임을 보이는 것을 말한다.

	지수(index number): 물가나 임금 등과 같이 해마다 변하는 것의 변화를 알아보기 쉽도록, 어느 해의 수량을 기준으로 잡아 이것을 100으로 잡아 그것에 대한 다른 해의 수량의 비율을 나타낸다. 다른 하나는 거듭제곱에서 밑에 대하여 제곱하게 되는 수를 말한다.

	직각(right angle): 각의 크기가 90도 인 각

	직교: 두 직선이나 평면이 교차하는 경우 그 교각이 90도인 경우 직교한다고 한다.

	직선의 방정식: 평면 위에서 직선의 모양을 식으로 표현한 것으로 y=ax +b꼴로 나타낸다.

	집합(set): 집합은 식별이 분명한 원소들로 구성된 모임을 말하고, 집합론에서 무정의용어로 취급된다.

	짝수점(even point): 한붓그리기 문제에서 길이 짝수 개만 있는 점을 말한다.

	차집합(difference of two sets): 집합 A에는 속하고 집합 B에는 속하지 않는 원소로 구성된 집합을 말하며 A-B로 표기한다.

	참값: 일정한 측정에 의하여 알려고 하는 양의 정확한 값을 말한다.

	최대값: 실수값을 취하는 함수가 그 정의역 안에서 취하는 값 중 가장 큰 값을 말한다.

	최대공약수(greatest common measure): 두 개 이상의 공약수중에서 최대인 것을 말함

	최소값: 실수값을 취하는 함수가 그 정의역 안에서 취하는 값 중 가장 작은 값을 말한다.

	최소공배수(least common multiple): 두 개 이상의 공배수 중에서 최소인 것을 말함

	축: 좌표평면에서 기준이 되는 선을 말하며 평면에서는 x축, y축이 있다.

	측정값: 어떤 계측기를 사용하여 관측을 한 값으로 이는 항상 오차를 포함하고 있다.

	치역(range): X 에서 Y에로의 함수에서 Y의 값이 취하는 범위


	코사인: 직각삼각형에서 삼각비를 나타내는데 밑변/빗변의 비의 값이다.


	탄젠트: 직각삼각형에서 삼각비를 나타내는데 높이/밑변의 비의 값이다.


	편차: 어떤 변량이 평균으로부터 떨어져 있는 차이를 말한다.

	평각(straight angle): 각의 두 변이 꼭지점의 양쪽에 있고, 한 직선을 이룰 때 이 각을 평각이라고 하고 180도를 의미한다.

	평균: 변량들의 값을 총 도수로 나눈 값

	평행(parallel): 두 도형의 위치관계를 말하는 것으로 동일한 평면 위에서 서로 다른 직선이 만나지 않는 경우 이를 두 직선이 평행한다고 한다.

	평행사변형: 두 쌍의 대변이 각각 평행인 4변형을 말한다.

	평행선(parralel curve): 평면 위의 하나의 곡선을 따라서 그 곡선과 공통의 법선을 갖는 곡선을 원래의 곡선과 평행이라고 한다.

	평행이동: 평면 위에서 점이나 도형을 일정한 방향, 일정한 거리만큼 이동시킨 것을 말함

	포물선: 정해진 한 점과 한 직선으로부터 같은 거리에 있는 점들의 자취를 말한다.

	표준편차: 편차의 제곱합을 총 도수로 나눈 다음 제곱근을 취한 것으로 자료의 흩어짐 정도를 재는 척도이다.

	피타고라스의 정리: 직각삼각형에서 빗변의 제곱은 다른 두 변의 각각의 제곱의 합과 같다.


	한붓그리기: 평면 위에 어떤 도형을 그릴 경우 한 번 붓을 댄 이후에는 떼지 말고 그리고 같은 선을 다시 지나는 일이 없도록 그리는 방법

	할선(secant line): 원 밖의 한 점으로부터 그은 직선이 원 위의 두 점을 지나 원을 자르는 경우. 이 때의 선을 할선이라 한다.

	함수값: 어떤 함수에서 정의역 x의 값을 대입하면 치역 y값이 결정되는데 이 값을 함수값이라 한다.

	함수: 두 개의 변수 사이에 어떤 대응관계가 있어 x값이 정해지면 y의 값이 오직 한 개가 대응하는 관계를 함수라 한다.

	함수의 그래프: X 에서 Y에로의 함수를 좌표평면 위의 (x,y)좌표로서 그래프로 표현한 것

	합동(congruent): 두 개의 도형이 운동에 의해 완전히 포개질 경우 이를 합동이라 한다.

	합성수(composite number): 1과 자신의 수 이외의 약수를 갖는 수를 말한다. 즉 소수가 아닌 1보다 큰 수를 일컫는다.

	합집합(union set): 두 개의 집합 A, B에 대하여 A에 속하거나 B에 속하거나, 혹은 두 집합 모두에 속한 모든 원소의 집합을 말함

	항(term): 수나 문자들의 곱(상)이나 합(차)으로 이루어진 식을 항이라 부른다.

	항등식(identity): 등식에서 그 속의 문자에 어떤 값을 대입하여도 언제나 성립하는 식

	해(solution): 근이라고도 하며 어떤 방정식을 만족하는 미지수의 값을 의미한다.

	현(chord): 원주 위의 두 점을 맺는 선분을 말한다.

	호(arc): 원주의 일부분을 말한다.

	홀수점: 한붓그리기 문제에서 길이 홀수개만 있는 점을 말한다.

	확률: 하나의 사건이 일어날 수 있는 가능성을 수로 나타낸 것으로 수학적 확률과 경험적 확률이 있다.

	활꼴(segment): 원의 호와 그 양끝을 잇는 현에 의해서 형성되는 도형

	회전체(solid of revolution): 평면도형을 그 평면 위에서 한 직선을 축으로하여 1회전 시켰을 때 생기는 입체를 회전체라고 한다.

	히스토그램(histogram): 도수분포표를 나타내는 일종의 그래프이다. 수평축에 계급구간을, 수직 축에 도수나 도수밀도(상대도수밀도)를 표시한 그래프이다.

	 

	abscissa 횡좌표, 좌표
	absolute value 절대값
	acre 에이커
	actual price 실제가격
	acute angle 예각
	acute triangle 예각 삼각형
	add 더하다
	addictive inverse 합이 0이 되는 2개의 수
	adjacent 인접한(이웃하는)
	adjacent angles 인접각
	algebra 대수
	alternate angle 엇각
	alternate interior angle 안 쪽의 엇각
	altitude 높이, 고도
	angle 각
	approximation 근사치
	arc 호
	area 면적
	arithmetic 산수, 산술
	arithmetic mean = average 산술 평균
	arithmetic progression 등차 수열
	ascending order 오름순
	associate law 결합법칙
	associative law 결합 법칙
	asymmetric 비대칭적
	average 산술평균
	average rate
	average speed 평균 속도
	axis 축

	decagon 십각형
	decimal 1. 소수(=decimal fraction)
	decimal point 소수점
	decimals 소수
	decrease by 감소하다
	deduce 연역하다, 추론하다
	degree 각도
	degree measure
	demension 차원, 도형의 변의 길이 denominator 분모
	derive 도출하다
	descending order 내림순
	develop 전개하다
	diagonal 대각선
	diagonal line 대각선
	diameter 지름
	difference 차 digit 0-9까지 10개의 number, 자릿수
	direct proportion 정비례
	discontunuous
	discount 할인
	discount price 할인가격
	dispersion 분산
	distance 거리
	distributive law 배분 법칙
	dividend
	피제수,어떤 수에의해 나누어지는 수
	division 나누기
	divisor 분모, 어떤 수를 나누는 수, 제수 dotted line 점선
	drawn to scale
	일정한 비율로 축소(확대)하여 그려진

	edge 모서리
	edge 입방체의 한 변
	elapse 시간이 흐르다
	empty set 공집합
	equation 식(방정식)
	equidistance 등거리
	equidistant 거리가 같은
	equilateral 등변의
	equilateral triangle 정삼각형
	equivalent 등치의, 등가의
	estimate 추산, 평가
	eval　　uate 값을 구하다
	even number 짝수
	exponent 지수
	exterior angle 외각

	geometric mean 기하평균
	geometry 기하학
	greater than 보다큰
	greater than or equal to
	greatest common divisor 최대공약수 greatest common measure(GCM) 최대 공약수
	grid 격자
	in dollars 달러 값으로 표현된
	in terms of dollars increase 증가
	increase by 증가하다
	increment 증가(단계별)
	indirectly propotional 반비례
	inequalities = inequity 부등식
	inequalities 부등식
	infinite decimal 무한 소수
	inscribed 내접하는
	integer 정수
	intercept 절편, 교차점
	interest 이자
	interior angle 내각
	intersect 교차하다
	intersection 교차점
	invalid 무효의
	inverse 역수
	inverse proportion 반비례
	irrational number 무리수
	isosceles 이등변 삼각형 

	magnitude 규모, 크기
	major arc 원호중에서 큰 호
	markup 원가에 더해지는 양
	matrix 행렬
	mean 평균
	median 중간값
	minor arc 원호중에서 작은 호
	mixed number 대분수
	mode 최빈도수
	monomial 단항
	multiple 배수
	multiply 곱하기

	obtuse angle 둔각
	obtuse triangle 둔각 삼각형
	octagon 8각형
	octagon 팔각형
	odd 홀수
	odd number 홀수
	ones digit
	operation 연산
	ordinal number 서수
	ordinate 종좌표
	origin 원점

	quadrant (I, II, III, Iv) (1, 2, 3, 4) 사분면 quadrant 원이나 원주의 1/4이 되는 부분
	quadratic 2차의
	quadratic equation 2차 방정식
	quadrilateral 사각형
	quotient 몫

	radical sign 무리수를 나타내는 기호(root) radius 반지름
	range 분포
	range of measurement 최대값-최소값
	rate 속도
	ratio 비, 비율 the ratio of A to B : A/B
	ratio 비율
	real number 실수
	reciprocal 역수
	rectangle 직사각형
	rectangular coordinate plane (이차원의) 면 rectangular coordinate system xy 좌표평면
	rectangular solid 직육면체
	reduce to simplest form 약분하다
	reflex angle 우각(180이상 360미만)
	region 영역
	regular polygon 장다각형
	regular(right) pyramid : 정(직)각추
	relative prime 서로 소
	remainder 나머지
	represent 나타내다
	reverse 역수
	revolution 회전수, 주기
	rhombus 마름모
	right angle 직각
	right triangle 직삼각형
	root 방정식의 근, 제곱근
	round off (소수점계산)버리다
	rounding (to the nearest whole number) : 반올림
	rounding off : 아래 자리의 수를 버림
	rounding off numbers 반올림
	rounding up : 아래 자리의 수를 올림
	table 표
	tangent 기울기, 접하다
	tangent line 접선
	tangent to a circle 원에 접하는
	tens digit 십의 자리
	tenths digit 소수점 첫째자리의 수
	term 항
	the volume of a cube 정육면체의 부피
	thousands digit 천의 자리
	thousandths digit 소수 셋째 자리
	times 배수
	trapezoid 사다리꼴
	triangle 삼각형
	unit 단위
	units digit 일자리에 있는 수
	unknown 미지수의
	value 값
	variable 변수
	vertex (vertices) 꼭지점
	vertical 수직
	vertical angle 맞꼭지각
	volume 부피, 양
	wage 임금
	weight 무게
	whole number 0과 양의 정수 0,1,2,3…
	whole number 자연수
	width 폭
	X coordinate 좌표축에서 x 값
	X-axis x-축
	XY-plane
	bar graph 막대 그래프
	base 밑변
	between A and B A와 B를 포함하지 않는다.
	between A and B, inclusive A와 B를 포함한다.
	billion 십억
	bisect 양분하다, 이등분하다
	bisection 이등분
	block 육면체(cf) solid : 입체
	break even 수입과지출이 서로 상쇄되다
	by ...에 따라서 분류한

	calculate 계산하다.
	cancel 약분하다
	canceling 약분
	capacity 용적
	cardinal number 기수
	Celsius 섭씨
	center 중심
	centigrade
	central angle 중심각
	chord 현
	circle 원
	circumference 원둘레, 원주
	circumscribed 외접한
	clockwise 시계방향으로
	coefficient 계수
	combination 조합
	common denominator 공통분모
	common faction 상 분수
	(소수로 표시될 수 없는 분수)
	common factor = common measure
	공약수 = 공통 인수
	common multiple 공배수
	common ratio 공비
	commutative law 교환 법칙 complementary angle 여각
	complex fraction 대분수
	compound interest 복리
	concave 오목형
	concentric 동심원의
	concentric circle 동심원
	cone 원뿔
	cone 원추
	congruence = congruent 합동
	consecutive 연속적인
	consecutive even integers ...0, 2, 4, 6…. consecutive odd integers …1, 3, 5, 7… constant 상수
	constant rate 일정속도
	continuous 연속의 불연속
	convex 볼록형
	coordinate 좌표
	coordinate plane 면
	corresponding angle 동위각
	cost 원가, 가격, 비용
	counter-clockwise 시계반대방향
	cross-hatched region
	cube 입방체, 정육면체
	cubic meter 입방 미터
	cubic root 삼 제곱근
	cylinder 원기둥

	face 면
	factor 인수(약수)
	factorable 인수분해 가능한
	factoring 인수의 곱으로 표현
	factorization = resolution into factors 인수 분해
	Fahrenheit 화씨
	figure 도형
	formula 공식
	fraction 분수
	frequency 빈도
	fringe benefit 기타 혜택
	from A throughout B A와 B를 포함한다
	from A to B A와 B를 포함한다
	function 함수

	harmonic mean 조화 평균
	height 높이
	heptagon 7각형
	hexagon 6각형
	horizontal 수평의
	hundreds digit 백의 자리
	hundredths digit 소수 둘째 자리
	hyperbolic 포물선
	hypertenuse 직각 삼각형의 사변 hypotenuse 삼각형의 빗변

	least common denominator 최소 공통분모 least common multiple(LCM) 최소 공배수 left side 좌변
	leg 변
	legs 밑변(직삼각형에서)
	length 길이
	less than 미만
	less than or equal to 이하
	line 직선
	line graph 선형 그래프
	line segment 선분
	linear equation 일차 방정식
	lowest common denominator 최소공통분모 lowest common multiple 최소공배수
	lowest term 기약분수
	lowest terms 기약분수로 만드는 것

	natural number 자연수
	negative 음의
	negative integer 음의 정수
	negative multiple 음의 배수
	negative number 음수
	no greater than 이하
	no less than 이상
	nanogon 9각형
	nonzero integer 영이 아닌 정수
	not equal to number line 수를 나타낼 수 있는 선
	numerator 분자


	parallel 평행의
	parallel lines 평행인 선
	parallelogram 평행사변형
	parentheses 괄호
	partition 3차원도형이나 집합을 부분으로 나누다
	pentagon 오각형
	percentage 백분율
	perimeter 다각형의 둘레 길이
	period 주기
	permutation 순열
	perpendicular 수직
	perpendicular lines 수직으로 만나는 선
	pi 약 3.14
	pie graph 원형도표
	place value 자리 수
	plane 평면
	plot 도면
	point 점
	point of tangency 원과 접선이 만나는 점 point of tangency 접점
	polygon 다각형
	polynomial 다항식의
	positive 양의
	positive integer 양의 정수
	positive multiple 양의 배수
	positive number 양수
	power 자기 자신의수를 곱하는 것
	power 제곱
	price 가격
	prime factor 소인수
	prime factorization 소인수 분해
	prime number 소수
	probability 확률
	product 곱
	product 곱하기 값
	profit = benefit 이익(이윤)
	progression 수열
	proportion 비율, 비례
	pyramid 삼각뿔, 사각뿔 등의 각추 Pythagorean's theorem 피타고라스의 정리
	salary 봉급 
	sales volume 판매량
	scalene 부등삼각형
	scalene triangle 부등변 삼각형
	secant 할선
	section 3차원도형의 자른 면
	sector 부채꼴
	segment 선분
	segment 선의 부분
	selling price 판매가격
	semicircle 반원
	septagon 구각형
	set 집합shaded region 빗금친 부분
	side 변
	sign 부호
	similar (도형에서) 닮은 꼴
	simple interest 단리
	simplify 간략하게 하다
	simplify a fraction 분수를 약분하다
	simplify an equation 등식을 간략하게 만들다
	slope 기울기
	solid 입체물
	solid line 실선
	sphere 구체
	square 정사각형, 제곱(단위)
	square a number 제곱하다
	square meter 평방미터
	square root 제곱근
	standard deviation 표준 편차
	straight angle 평각 180도
	straight line 직선
	substitution 대치
	subtract = deduct 빼다
	such that 수식이나 논리표현에서 조건을 설정할 때 사용
	sum 합
	supplementary angle 보각, 합해서 180도가 되는 두각
	surface area (입체 도형에서) 표면적 symmetrical 대칭의

	Y coordinate 좌표축에서 y 값
	Y-axis y 축
	
	*/
	
	
}
