var elName = document.getElementById('name');
var elLastname= document.getElementById('lastname')
var elTeam = document.getElementById('team');
var elCar = document.getElementById('car')
var elRaceAdd = document.getElementById('addRace');
var elMsgName = document.getElementById('feedbackName');
var elMsgLastname = document.getElementById('feedbackLastname');
var elMsgTeam = document.getElementById('feedbackTeam');
var elMsgCar = document.getElementById('feedbackCar');
var elAddDriver = document.getElementById('addDriver');

function checkName(minLength){
    if(elName.value.length < minLength){
        elMsgName.textContent = 'Imie zawodnika nie może być puste!';
    } else {
        elMsgName.innerHTML='';
    }
}
function checkLastname(minLength){
    if(elLastname.value.length < minLength){
        elMsgLastname.textContent = 'Nazwisko zawodnika nie może być puste';
    } else {
        elMsgLastname.innerHTML='';
    }
}
function checkTeam(minLength){
    if(elTeam.value.length < minLength){
        elMsgTeam.textContent = 'Team zawodnika nie może być pusty';
    } else {
        elMsgTeam.innerHTML='';
    }
}
function checkCar(minLength) {
    if (elCar.value.length < minLength) {
        elMsgCar.textContent = 'Nazwa samochodu zawodnika nie może być pusta';
    } else {
        elMsgCar.innerHTML = '';
    }
}

    elAddDriver.addEventListener('click', function () {
        checkName(1);
        checkLastname(1);
        checkTeam(1);
        checkCar(1);
    }, false);
