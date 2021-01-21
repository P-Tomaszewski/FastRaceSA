var elName = document.getElementById('driver');
var elMsgTeam = document.getElementById('feedbackDriver');
var elAddDriver = document.getElementById('showScore');

function setDriver(){
    elMsgTeam.textContent = '' + elName.value;
}

// function checkName(minLength){
//     if(elName.value.length < minLength){
//         elMsgName.textContent = 'Imie zawodnika musi mieć conajmniej ' + minLength + ' znaków!';
//     } else {
//         elMsgName.innerHTML='';
//     }
// }

elAddDriver.addEventListener('click', function () {
    setDriver()
}, false);

