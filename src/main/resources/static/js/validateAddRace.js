var elRaceName = document.getElementById('racename');
var elDate = document.getElementById('date')
var elRaceAdd = document.getElementById('addRace');
var elMsgRacename = document.getElementById('feedbackRacename');
var elMsgDate = document.getElementById('feedbackDate');

function checkRaceName(minLength){
    if(elRaceName.value.length < minLength){
        elMsgRacename.textContent = 'Nazwa wyscigu musi zawierac conajmniej 5 znaków!';
    } else {
        elMsgRacename.innerHTML='';
    }
}
function checkDate(){
    if(elDate.value.length == 0 ){
        elMsgDate.textContent = 'Wybierz date wyścigu!';
    } else {
        elMsgDate.innerHTML='';
    }
}

elRaceAdd.addEventListener('click', function (){
    checkRaceName(5);
    checkDate()
}, false);