var results = [
    {
        name: 'Arek',
        score: 60
    },
    {
        name: 'Antek',
        score: 11
    },
    {
        name: 'Piotr',
        score: 12
    }
];
$(function (){


    var $tableBody = $('<tbody></tbody>');
    for (var i = 0; i<results.length; i++){
        var person = results[i];
        var $row = $('<tr></tr>');
        $row.append($('<td></td>').text(person.name));
        $row.append($('<td></td>').text(person.score));
        $tableBody.append($row);
    }
    $('thead').after($tableBody);
})