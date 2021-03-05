/**
 * This script builds and sets up the nav bar at the top of the web page
 */
function header(){
    var rootElement = document.querySelector('#mainContainer');
    var headerElement = document.createElement("header");
    headerElement.setAttribute("id", "header");
    /*var imgContainerElement = document.createElement("div");
    imgContainerElement.setAttribute("class", "img-Container");
    var logoElement = document.createElement("img");
    logoElement.setAttribute("class", "profile-image");*/
    var navElement = document.createElement("nav");
    var unorderedElement = document.createElement("ul");
    unorderedElement.setAttribute("id", "headerULList");
    var listElement1 = document.createElement("li");
    var homeElement = document.createElement("a");
    homeElement.setAttribute("class", "header-button");
    homeElement.setAttribute("href", "./");
    homeElement.textContent = "HOME";
    var listElement2 = document.createElement("li");
    var aboutElement = document.createElement("a");
    aboutElement.setAttribute("class", "header-button");
    aboutElement.setAttribute("href", "./about");
    aboutElement.textContent = "ABOUT";
    var listElement3 = document.createElement("li");
    var adminElement = document.createElement("a");
    adminElement.setAttribute("class", "header-button");
    adminElement.setAttribute("href", "./admin");
    adminElement.textContent = "ADMIN";
	var listElement4 = document.createElement("li");
    var logoutElement = document.createElement("a");
    logoutElement.setAttribute("class", "header-button");
    logoutElement.setAttribute("href", "./logout");
    logoutElement.textContent = "LOGOUT";
 	var listElement5 = document.createElement("li");
    var accountElement = document.createElement("a");
    accountElement.setAttribute("class", "header-button");
    accountElement.setAttribute("href", "./account");
    accountElement.textContent = "ACCOUNT";


    rootElement.appendChild(headerElement);
    /*headerElement.appendChild(imgContainerElement);
    imgContainerElement.appendChild(logoElement);*/
    headerElement.appendChild(navElement);
    navElement.appendChild(unorderedElement);
    unorderedElement.appendChild(listElement1);
    listElement1.appendChild(homeElement);
    unorderedElement.appendChild(listElement2);
    listElement2.appendChild(aboutElement);
    unorderedElement.appendChild(listElement3);
    listElement3.appendChild(adminElement);
	unorderedElement.appendChild(listElement4);
    listElement4.appendChild(logoutElement);
	unorderedElement.appendChild(listElement5);
    listElement5.appendChild(accountElement);
}

header();