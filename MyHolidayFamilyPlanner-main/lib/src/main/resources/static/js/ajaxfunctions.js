// Beim laden der Seite - listeners werden registriert und existierende Urlaube in die Tabelle
$(document).ready(function () {
    // Tabellen werden beim öffnen der Seite direkt aufgerufen
    loadDataTableUrlaub();
    loadDataTableMensch();
    loadDataTableUrlaubswunsch();
    loadDataTableDashboard();
    
    // Dropdowns werden beim öffnen der Seite geladen
    loadUrlaubTitel();
    loadUrlaubID();
    loadUrlaubZeitraum();
    loadMenschID();
    loadUrlaubswunschID();
    

    //---------- Urlaube ----------//

    // die Funktion postUrlaub wird bei Knopfdruck aufgerufen
    $("#newUrlaub").submit(function (event) 
    {
        postUrlaub(event);
    });

    // die Funktion putUrlaub wird bei Knopfdruck aufgerufen
    $("#updateUrlaub").submit(function (event) 
    {
        putUrlaub(event);
    });

    // die Funktion deleteUrlaub wird bei Knopfdruck aufgerufen
    $("#deleteUrlaub").submit(function (event) 
    {
        deleteUrlaub(event);
    });

    //---------- Urlaubswunsch ----------//

    // die Funktion postUrlaubswunsch wird bei Knopfdruck aufgerufen
    $("#newUrlaubswunsch").submit(function (event) 
    {
        postUrlaubswunsch(event);
    });

    // die Funktion putUrlaubswunsch wird bei Knopfdruck aufgerufen
    $("#updateUrlaubswunsch").submit(function (event) 
    {
        putUrlaubswunsch(event);
    });

    // die Funktion deleteUrlaubswunsch wird bei Knopfdruck aufgerufen
    $("#deleteUrlaubswunsch").submit(function (event) 
    {
        deleteUrlaubswunsch(event);
    });

    //---------- Familienmitglied ----------//

    // die Funktion postMensch wird bei Knopfdruck aufgerufen
    $("#newMensch").submit(function (event) 
    {
        postMensch(event);
    });

    // die Funktion putMensch wird bei Knopfdruck aufgerufen
    $("#updateMensch").submit(function (event) 
    {
        putMensch(event);
    });

    // die Funktion deleteMensch wird bei Knopfdruck aufgerufen
    $("#deleteMensch").submit(function (event) 
    {
        deleteMensch(event);
    });

    //---------- Prio Rating ----------//

    // die Funktion postPrioRating wird bei Knopfdruck aufgerufen
    $("#newPrioRating").submit(function (event) 
    {
        postPrioRating(event);
    });

    // die Funktion deletePrioRating wird bei Knopfdruck aufgerufen
    $("#deletePrioRating").submit(function (event) 
    {
        deletePrioRating(event);
    });

    //---------- Daten laden ----------//

    // Die Tabelle mit den Urlauben wird geladen
    $('#loadUrlaubTable').click(function () 
    {
        loadDataTableUrlaub();
    });

    // Die Tabelle mit den Familienmitgliedern wird geladen
    $('#loadMenschTable').click(function () 
    {
        loadDataTableMensch();
    });

    // Die Tabelle mit den Urlaubswünschen wird geladen
    $('#loadUrlaubswunschTable').click(function () 
    {
        loadDataTableUrlaubswunsch();
    });

    // Die Tabelle mit den Urlaubswünschen wird geladen
    $('#loadDashboardTable').click(function () 
    {
        loadDataTableDashboard();
    });
    
});

//---------- Funktionen: Urlaub ----------//

function postUrlaub(event) // Urlaub hinzufügen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=urlaubID]').val(),
        'titel': $('input[name=urlaubTitel]').val(),
        'zeitraum': $('input[name=urlaubZeitraum]').val()
    };
    
    // Grundprozess der Funktion
    $.ajax({
        type: 'POST', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        url: '/urlaub', // die Addresse an welche die Daten gesendet werden
        data: JSON.stringify(formData), // die Daten welche gesendet werden
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableUrlaub(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=urlaubID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=urlaubTitel]').val('');
            $('input[name=urlaubZeitraum]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function putUrlaub(event) // Urlaub bearbeiten
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=updateUrlaubID]').val(),
        'titel': $('input[name=updateUrlaubTitel]').val(),
        'zeitraum': $('input[name=updateUrlaubZeitraum]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'PUT', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        url: '/urlaub/' + formData.id, // url where we want to PUT
        data: JSON.stringify(formData), // data we want to PUT
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableUrlaub(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=updateUrlaubID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=updateUrlaubTitel]').val('');
            $('input[name=updateUrlaubZeitraum]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function deleteUrlaub(event) // Urlaub löschen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=deleteUrlaubID]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'DELETE', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        data: JSON.stringify(formData), // data we want to DELETE
        url: '/urlaub/' + formData.id, // url where we want to DELETE

        success: function (result) 
        {
            console.log(result);
            loadDataTableUrlaub(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=deleteUrlaubID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
        }, 
        error: function (e) 
        {
            console.log(e);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

//---------- Funktionen: Urlaubswunsch ----------//

function postUrlaubswunsch(event) // Urlaubswunsch hinzufügen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
		'id': $('input[name=urlaubswunschID]').val(),
		'ort': $('input[name=urlaubswunschOrt]').val(),
		'beschreibung': $('input[name=urlaubswunschBeschreibung]').val(),
		'urlaub': 
		{
			'id': $('#dd_UrlaubID option:selected').val(),
		}
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'POST', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json',
        url: '/urlaubswunsch', // die Addresse an welche die Daten gesendet werden
        data: JSON.stringify(formData), // die Daten welche gesendet werden
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableUrlaubswunsch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=urlaubswunschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=urlaubswunschOrt]').val('');
            $('input[name=urlaubswunschBeschreibung]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function putUrlaubswunsch(event) // Urlaubswunsch bearbeiten
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=updateUrlaubswunschID]').val(),
        'beschreibung': $('input[name=updateUrlaubwunschBeschreibung]').val(),
        'ort': $('input[name=updateUrlaubswunschOrt]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'PUT', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        url: '/urlaubswunsch/' + formData.id, // url where we want to PUT
        data: JSON.stringify(formData), // data we want to PUT
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableUrlaubswunsch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=updateUrlaubswunschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=updateUrlaubswunschOrt]').val('');
            $('input[name=updateUrlaubwunschBeschreibung]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function deleteUrlaubswunsch(event) // Urlaubswunsch löschen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=deleteUrlaubswunschID]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'DELETE', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        url: '/urlaubswunsch{id}', // url where we want to DELETE
        data: JSON.stringify(formData), // data we want to DELETE
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableUrlaubswunsch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=deleteUrlaubswunschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

//---------- Funktionen: Familienmitglied ----------//

function postMensch(event) // Familienmitglied hinzufügen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=menschID]').val(),
        'name': $('input[name=menschName]').val(),
        'geburtstag': $('input[name=menschGeburtstag]').val(),
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'POST', // definiert die Aktion welche vom RestController ausgeführt werden soll(POST for our form)
        contentType: 'application/json', url: '/familienmitglied', // die Addresse an welche die Daten gesendet werden
        data: JSON.stringify(formData), // die Daten welche gesendet werden
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableMensch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=menschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=menschName]').val('');
            $('input[name=menschGeburtstag]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function putMensch(event) // Familienmitglied bearbeiten
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id': $('input[name=updateMenschID]').val(),
        'name': $('input[name=updateMenschName]').val(),
        'geburtstag': $('input[name=updateMenschGeburtstag]').val(),
    };

    // Grundprozess der Funktion
    $.ajax({
        type: 'PUT', // definiert die Aktion welche vom RestController ausgeführt werden soll(PUT for our form)
        contentType: 'application/json', 
        url: '/familienmitglied/' + formData.id, // url where we want to PUT
        data: JSON.stringify(formData), // data we want to PUT
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTableMensch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=updateMenschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
            $('input[name=updateMenschName]').val('');
            $('input[name=updateMenschGeburtstag]').val('');
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

function deleteMensch(event) // Familienmitglied löschen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
        'id2': $('input[name=deleteMenschID]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'DELETE', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        data: JSON.stringify(formData), // data we want to DELETE
        url: '/familienmitglied/' + formData.id2, // url where we want to DELETE

        success: function (result) 
        {
            loadDataTableMensch(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=deleteMenschID]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

//---------- Funktionen: Prio Rating ----------//

function postPrioRating(event) // Prio Rating hinufügen
{
    // Die Daten werden angeben und strukturiert.
    var formData = 
    {
		'id': 
		{
			'familienmitgliedId': $('#dd_MenschID option:selected').val(),
			'urlaubswunschId': $('#dd_UrlaubswunschID option:selected').val(),
		},
		'familienmitglied': 
		{
			'id': $('#dd_MenschID option:selected').val(),
		},
		'urlaubswunsch': 
		{
			'id': $('#dd_UrlaubswunschID option:selected').val(),
		},
        'prio': $('input[name=prio]').val()
    };
    // Grundprozess der Funktion
    $.ajax({
        type: 'POST', // definiert die Aktion welche vom RestController ausgeführt werden soll
        contentType: 'application/json', 
        url: '/priorating', // die Addresse an welche die Daten gesendet werden
        data: JSON.stringify(formData), // die Daten welche gesendet werden
        success: function (data, textStatus, jQxhr) 
        {
            loadDataTablePrioRating(); // Die Tabelle wird nach erfolgreicher Eingabe neu geladen
            $('input[name=prio]').val(''); // Die Eingabefelder werden ohne ein neuladen der Seite geleert
        }, 
        error: function (jqXhr, textStatus, errorThrown) 
        {
            console.log(errorThrown);
        }
    });
    // verhindert das neuladen der Seite
    event.preventDefault();
}

//---------- Funktionen: Daten für Tabellen laden ----------//

function loadDataTableUrlaub() // Die Tabelle mit den Urlauben wird geladen
{
    var table = $('#urlaubtable').DataTable({
        destroy: true, "ajax": 
        {
            "url": "/urlaub", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        }, 
        	"columns": [{"data": "id"}, {"data": "titel"}, {"data": "zeitraum"}]
    });
}

function loadDataTableMensch() // Die Tabelle mit den Familienmitgliedern wird geladen
{
    var table = $('#menschtable').DataTable({
        destroy: true, "ajax": 
        {
            "url": "/familienmitglied", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        }, 
        	"columns": [{"data": "id"}, {"data": "name"}, {"data": "geburtstag"}]
    });
}

function loadDataTableUrlaubswunsch() // Die Tabelle mit den Familienmitgliedern wird geladen
{
    var table = $('#urlaubswunschTable').DataTable({
        destroy: true, "ajax": 
        {
            "url": "/urlaubswunsch", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        }, 
        	"columns": [{"data": "id"}, {"data": "ort"}, {"data": "beschreibung"}, {"data": "urlaub.titel"}]
    });
}

function loadDataTableDashboard() // Die Tabelle mit den Familienmitgliedern wird geladen
{
    var table = $('#dashboardTable').DataTable({
        destroy: true, "aLengthMenu": [[25, 50, 75, -1], [25, 50, 75, "Alle"]], "pageLength": 25, "ajax": 
        {
            "url": "/avgpriorating", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        },
    });
}

//---------- Funktionen: Dropdows laden ----------//

//---------- Urlaub ----------//

function loadUrlaubID()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaub", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_UrlaubID').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubID').append('<option value="">Wähle eine Urlaub ID</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj)  // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.id+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubID'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadUrlaubTitel()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaub", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_UrlaubTitel').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubTitel').append('<option value="">Wähle den passenden Urlaub</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj)  // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.titel+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubTitel'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadUrlaubZeitraum()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaub", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_UrlaubZeitraum').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubZeitraum').append('<option value="">Wähle den passenden Zeitraum</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.zeitraum+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubZeitraum'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

//---------- Familienmitglied ----------//

function loadMenschID()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/familienmitglied", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_MenschID').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_MenschID').append('<option value="">Wähle deine ID</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.id+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_MenschID'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadMenschName()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/familienmitglied", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_MenschName').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_MenschName').append('<option value="">Wähle deinen Namen</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.name+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_MenschName'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadMenschGeburtstag()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/familienmitglied", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_MenschGeburtstag').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_MenschGeburtstag').append('<option value="">Wähle deinen Geburtstag</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.geburtstag+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_MenschGeburtstag'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

//---------- Urlaubswunsch ----------//

function loadUrlaubswunschID()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaubswunsch", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_UrlaubswunschID').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubswunschID').append('<option value="">Wähle einen Urlaubswunsch</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.id+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubswunschID'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadUrlaubswunschOrt()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaubswunsch", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) {
				$('#dd_UrlaubswunschOrt').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubswunschOrt').append('<option value="">Wähle den passenden Ort</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.ort+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubswunschOrt'); // fügt die Optionen dem select Objekt hinzu
                });  
            }
      	});
}

function loadUrlaubswunschBeschreibung()
{
        $.ajax({
	        type: "GET", // definiert die Aktion welche vom RestController ausgeführt werden soll
	        contentType: 'application/json',
	        url:"/urlaubswunsch", // die Addresse von welcher die Daten geholt werden
	        dataType: "json",

	        success: function (data) 
	        {
				$('#dd_UrlaubswunschBeschreibung').empty(); // Leert das select object (entfernt den ersten, leeren, Eintrag)
				$('#dd_UrlaubswunschBeschreibung').append('<option value="">Wähle die passende Beschreibung</option>'); // die Eingabeaufforderung wird hinzugefügt
                $.each(data ,function(i,obj) // eine Schleife welche jedes Datenobject durchläuft
                {
	                var div_data="<option value="+obj.id+">"+obj.beschreibung+"</option>"; // generiert die Optionen des select Objekts aus den gegeben Daten
	                $(div_data).appendTo('#dd_UrlaubswunschBeschreibung'); // fügt die Optionen dem select Objekt hinzu 
                });  
            }
      	});
}