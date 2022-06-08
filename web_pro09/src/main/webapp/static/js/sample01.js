/**
 * 
 */
res1 = document.getElementById("res1");

var arr1 = [1, 2, 3, 4];
res1.innerHTML += "var arr1 = [1, 2, 3, 4];" + "<br>";
res1.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res1.innerHTML += "<br>";

var arr2 = new Array(1, 2, 3, 4);
res1.innerHTML += "var arr2 = new Array(1, 2, 3, 4);" + "<br>";
res1.innerHTML += "실행 후 출력 결과 : " + arr2 + "<br>";
res1.innerHTML += "<br>";

res2 = document.getElementById("res2");
res2.innerHTML += "arr1[0] -> " + arr1[0] + "<br>";
res2.innerHTML += "arr1[1] -> " + arr1[1] + "<br>";
res2.innerHTML += "arr1[2] -> " + arr1[2] + "<br>";
res2.innerHTML += "<br>";

res3 = document.getElementById("res3");
res3.innerHTML += "arr1.indexOf(2) -> " + arr1.indexOf(2) + "<br>";
res3.innerHTML += "arr1.indexOf(3) -> " + arr1.indexOf(3) + "<br>";
res3.innerHTML += "arr1.indexOf(4) -> " + arr1.indexOf(4) + "<br>";
res3.innerHTML += "arr1.indexOf(5) -> " + arr1.indexOf(5) + "<br>";
res3.innerHTML += "<br>";

res4 = document.getElementById("res4");
res4.innerHTML += "arr1.concat(['a', 'b', 'c']) -> " + arr1.concat(['a', 'b', 'c']) + "<br>";
res4.innerHTML += "arr1 -> " + arr1 + "<br>";
res4.innerHTML += "<br>";

res5 = document.getElementById("res5");
res5.innerHTML += "arr1.join() -> " + arr1.join() + "<br>";
res5.innerHTML += "arr1.join('/') -> " + arr1.join('/') + "<br>";
res5.innerHTML += "arr1.join('-') -> " + arr1.join('-') + "<br>";
res5.innerHTML += "<br>";

res6 = document.getElementById("res6");
res6.innerHTML += "arr1.push(10) -> 배열크기:" + arr1.push(10) + "<br>";
res6.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res6.innerHTML += "<br>";
res6.innerHTML += "arr1.push(20, 30) -> 배열크기:" + arr1.push(20, 30) + "<br>";
res6.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res6.innerHTML += "<br>";

res7 = document.getElementById("res7");
res7.innerHTML += "arr1.unshift(5) -> 배열크기:" + arr1.unshift(5) + "<br>";
res7.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res7.innerHTML += "<br>";
res7.innerHTML += "arr1.unshift(6, 7) -> 배열크기:" + arr1.unshift(6, 7) + "<br>";
res7.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res7.innerHTML += "<br>";

res8 = document.getElementById("res8");
res8.innerHTML += "arr1.pop() -> 삭제된값:" + arr1.pop() + "<br>";
res8.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res8.innerHTML += "<br>";

res9 = document.getElementById("res9");
res9.innerHTML += "arr1.shift() -> 삭제된값:" + arr1.shift() + "<br>";
res9.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res9.innerHTML += "<br>";

res10 = document.getElementById("res10");
res10.innerHTML += "arr1.slice(2) -> 잘려진배열값:" + arr1.slice(2) + "<br>";
res10.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res10.innerHTML += "<br>";
res10.innerHTML += "arr1.slice(2, 6) -> 잘려진배열값:" + arr1.slice(2, 6) + "<br>";
res10.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res10.innerHTML += "<br>";

res11 = document.getElementById("res11");
res11.innerHTML += "arr1.splice(1, 0, 21, 22) -> 삭제된값:" + arr1.splice(1, 0, 21, 22) + "<br>";
res11.innerHTML += "실행 후 출력 결과 추가된 값 : " + arr1 + "<br>";
res11.innerHTML += "<br>";
res11.innerHTML += "arr1.splice(3, 5, 23, 24) -> 삭제된값:" + arr1.splice(3, 5, 23, 24) + "<br>";
res11.innerHTML += "실행 후 출력 결과 추가된 값 : " + arr1 + "<br>";
res11.innerHTML += "<br>";

res12 = document.getElementById("res12");
res12.innerHTML += "arr1.sort() -> " + arr1.sort() + "<br>";
res12.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res12.innerHTML += "<br>";
res12.innerHTML += "arr1.sort(function(x, y) { return x - y; }) -> "
	+ arr1.sort(function(x, y) { return x - y; }) + "<br>";
res12.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res12.innerHTML += "<br>";
res12.innerHTML += "arr1.sort(function(x, y) { return y - x; }) -> "
	+ arr1.sort(function(x, y) { return y - x; }) + "<br>";
res12.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res12.innerHTML += "<br>";

res13 = document.getElementById("res13");
res13.innerHTML += "arr1.reverse() -> " + arr1.reverse() + "<br>";
res13.innerHTML += "실행 후 출력 결과 : " + arr1 + "<br>";
res13.innerHTML += "<br>";


/**
 *
 */
var input1 = document.getElementById("input1");
var exam1 = document.getElementById("exam1");

var arr3 = input1.value.split(",");

for(let i = 0; i < arr3.length; i++) {
	arr3[i] = arr3[i].trim();
}

exam1.innerHTML = "['" + arr3.join("', '") + "']";


/**
 *
 */
var input2 = document.getElementById("input2");
var exam2 = document.getElementById("exam2");

var arr4 = input2.value.split(",");
var total = 0;

for(let item of arr4) {
	item = parseInt(item);
	arr3.push(item);
	total += parseInt(item);
}

// arr3 = arr3.concat(arr4);
arr3.push(total);

exam2.innerHTML = "['" + arr3.join("', '") + "']";







