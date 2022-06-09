/**
 * 
 */
var std = {
    name: "홍길동",
    age: 23,
    gender: "M"
};

function f1() {
	var res1 = document.getElementById("res1");
	res1.innerHTML += "var std = {" + "<br>";
	res1.innerHTML += "    name: '홍길동'," + "<br>";
	res1.innerHTML += "    age: 23," + "<br>";
	res1.innerHTML += "    gender: 'M'" + "<br>";
	res1.innerHTML += "}" + "<br>";
}

function f2() {
	var res2 = document.getElementById("res2");
	res2.innerHTML += "std.name -> " + std.name + "<br>";
	res2.innerHTML += "std['name'] -> " + std["name"] + "<br>";
}


function f3() {
	var res3 = document.getElementById("res3");
	for(let key in std) {
    	res3.innerHTML += "std['" + key + "'] -> " + std[key] + "<br>";
	};
}

function f4() {
	// 사용자 입력값을 추출하여 genStudent 에 전달한다.
	// 사용자 입력값이 없는 경우 res4 에 값을 입력하라는 메시지를 출력한다.
	var name = document.getElementById("id_input1_name");
	var age = document.getElementById("id_input1_age");
	var gender = document.getElementById("id_input1_gender");
	var res4 = document.getElementById("res4");
	var n, a, g;
	
	if(!name.value) {
		res4.innerHTML = "이름을 입력하세요.";
		name.focus();
		return;
	}
	n = name.value;
	
	if(!age.value) {
		res4.innerHTML = "나이를 입력하세요.";
		age.focus();
		return;
	}
	a = parseInt(age.value);
	
	if(gender.selectedIndex == 0) {
		res4.innerHTML = "성별을 선택하세요.";
		gender.focus();
		return;
	}
	g = gender.value;
	
	var student = genStudent(n, a, g);
	
	res4.innerHTML = "";
	for(let key in student) {
    	res4.innerHTML += "student['" + key + "'] -> " + student[key] + "<br>";
	};
}

function genStudent(name, age, gender) {
	var student = {
		name: name,
		age: age,
		gender: gender
	};
	return student;
}



















