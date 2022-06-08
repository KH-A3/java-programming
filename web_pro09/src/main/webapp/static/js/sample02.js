/**
 * 
 */
function f1() {
	console.log("함수가 실행되었습니다.");
}

function f2() {
	return "리턴이 있는 함수";
}

function f3() {
	// return;
}

var f4 = function() {
	return "익명함수 입니다."
};

(function() {
	console.log("즉시 실행하는 함수 입니다.");
})();


function f5(x) {
	console.log("매개변수 x 의 값 -> " + x);
}

function f6(x, y=0) {
	console.log("매개변수 x, y 의 값 -> " + x + ", " + y);
}

function f7(x, ...args) {
	console.log("매개변수 x 의 값 -> " + x);
	console.log("가변매개변수 args 의 값들");
	for(let arg of args) {
		console.log("\t" + arg);
	}
}

function f8(x, y=0, ...args) {
	console.log("매개변수 x, y 의 값 -> " + x + ", " + y);
	console.log("가변매개변수 args 의 값들");
	for(let arg of args) {
		console.log("\t" + arg);
	}
}















