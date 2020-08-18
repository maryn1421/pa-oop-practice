document.getElementById("next-btn").addEventListener('click', loadNewExercise )

function loadNewExercise() {
    stopwatch.stop();
    let url = window.origin + "/random";
    let newRequest = new XMLHttpRequest();
    newRequest.open('GET', url);
    newRequest.onload = function () {
        let ourData = JSON.parse(newRequest.responseText);
        refreshExercise(ourData);
    };
    newRequest.onerror = function () {
        console.log("Connection error");
    };
    newRequest.send();
}

function refreshExercise(item) {
    const text = document.getElementById("question-body");
    text.innerText = item.text;
    const title = document.getElementById("title");
    title.textContent = item.title;
    stopwatch.reset();
    stopwatch.print();
}