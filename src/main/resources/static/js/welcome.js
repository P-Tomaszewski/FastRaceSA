var today = new Date();
var hourNow = today.getHours();
var greeting;

if(hourNow> 18){
    greeting = 'Good evening!';
} else if(hourNow > 10){
    greeting = 'Good morning!';
} else {
    greeting = 'Welcome!';
}

document.write('<h1>' + greeting.fontcolor('#D9DADA') + '<h1>');
