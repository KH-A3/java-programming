/**
 * 
 */
function f1() {
	var id1 = document.getElementById("id1");
	var first_li = id1.firstElementChild;
	var last_li = id1.lastElementChild;
	
	first_li.style.color = "red";
	last_li.style.color = "blue";
}

function f2() {
	var id2 = document.getElementById("id2");
	var prev_li = id2.previousElementSibling;
	var next_li = id2.nextElementSibling;
	
	prev_li.style.color = "red";
	next_li.style.color = "blue";
}

function f3() {
	var id3 = document.getElementById("id3");
	var ul = id3.parentElement;
	
	ul.style.backgroundColor = "white";
}

function addUrlList() {
	var url = document.getElementById("id_url");
	var name = document.getElementById("id_name");
	var num = document.getElementById("id_num");
	var idx = parseInt(num.value);
	
	if(!url.value) {
		url.focus();
		return;
	} else if(!name.value) {
		name.focus();
		return;
	}
	
	var li_tags = document.getElementsByTagName("li");
	if(!idx || idx > li_tags.length || idx <= 0) {
		idx = li_tags.length - 1;
	} else {
		idx = idx - 2;
	}
	
	var li = document.createElement("li");
	var a = document.createElement("a");
	
	a.setAttribute("href", url.value);
	a.innerText = name.value;
	
	li.appendChild(a);
	if(idx < 0) {
		li_tags[0].before(li);
	} else {
		li_tags[idx].after(li);
	}
	
	url.value = "";
	name.value = "";
	num.value = "";
	num.focus();
}












