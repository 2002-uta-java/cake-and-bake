/**
 * 
 */

var title = new String();
var supplies = new Array();
var instructions = new Array();
var instNotes = [ [] ];

supplies[0] = new String();
instructions[0] = new String();
instNotes[0][0] = new String();

function refreshPreview() {
	$('#previewDiv').fadeOut("slow", function() {
		// call back function (call once it's faded out)

		$("#previewDiv").empty();

		// create html for displaying the new recipe
		var previewHTML = printTitle();
		previewHTML += printSupplies();
		previewHTML += printSteps();
		previewHTML += printNotes();

		$("#previewDiv").append(previewHTML);

		$('#previewDiv').fadeIn("slow");
	});

}

function printTitle() {
	var titleHTML = "<div id='title'>";
	titleHTML += "<h1>" + title + "</h1>";
	titleHTML += "</div>";

	return titleHTML;
}

function printSupplies() {
	var supplyHTML = "<div id='supplies'/>";

	supplyHTML += "<h3>Supplies</h3>";
	supplyHTML += "<ul>";

	var numSupplies = supplies.length;

	for (var supplyIndex = 0; supplyIndex < numSupplies; ++supplyIndex) {
		var supply = supplies[supplyIndex];
		supplyHTML += "<li id='supply" + supplyIndex
				+ "' onclick='handleEdit(this.id)'>" + supply + "</li>";
		// console.log("adding supply node: " + "<li id='supply" + supplyIndex
		// + "' onclick='handleEdit(this.id)'>" + supply + "</li>");
		// console.log("supply: " + supply + " and supplies[" + supplyIndex
		// + "]: " + supplies[supplyIndex]);
	}
	supplyHTML += "</ul>";

	supplyHTML += "</div>";

	return supplyHTML;
}

function printSteps() {
	var instHTML = "<div id='steps'>";

	instHTML += "<h3>Steps</h3>";
	instHTML += "<ol>";

	var numInst = instructions.length;

	for (var instIndex = 0; instIndex < numInst; ++instIndex) {
		inst = instructions[instIndex];
		instHTML += "<li id='inst" + instIndex
				+ "' onclick='handleEdit(this.id)'>" + inst + "</li>";
	}

	instHTML += "</ol>";

	instHTML += "</div>";

	return instHTML;
}

function printNotes() {
	var notesHTML = "<div id='notes'>";
	notesHTML += "<h3>Notes</h3>";

	notesHTML += "<ol>";

	var numInstNotes = instNotes.length;

	for (var instIndex = 0; instIndex < numInstNotes; ++instIndex) {
		var numNotes = instNotes[instIndex].length;

		if (numNotes > 0) {
			notesHTML += "<li value='" + (instIndex + 1) + "'>";
			notesHTML += "<ul type='disc'>";
			for (var noteIndex = 0; noteIndex < numNotes; ++noteIndex) {
				notesHTML += "<li id='notes" + instIndex + "" + noteIndex
						+ "'>" + instNotes[instIndex][noteIndex] + "</li>";
			}
			notesHTML += "</ul>";
			notesHTML += "</li>";
		}
	}
	notesHTML += "</ol>";

	notesHTML += "</div>";

	return notesHTML;
}

function refreshSupplies() {
	var numSupplies = $('#suppliesList').children().length;
	for (var supplyIndex = 0; supplyIndex < numSupplies; ++supplyIndex) {
		var val = $("#supplyInput" + (supplyIndex + 1)).val();
		if (val != null) {
			supplies[supplyIndex] = val;
		} else {
			supplies[supplyIndex] = "";
		}
		// console.log("supplies[" + supplyIndex + "]: " +
		// supplies[supplyIndex]);
	}
}
function refreshInst() {
	var numInst = $('#instList').children().length;
	for (var instIndex = 0; instIndex < numInst; ++instIndex) {
		var val = $("#instInput" + (instIndex + 1)).val();
		if (val != null) {
			instructions[instIndex] = val;
		} else {
			instructions[instIndex] = "";
		}
		// console.log("supplies[" + supplyIndex + "]: " +
		// supplies[supplyIndex]);
	}
}

function refreshNotesEdit() {
	// need to add notes for each instruction
}

$(document).ready(
		function() {

			$("#suppliesDiv").hide();
			$("#instDiv").hide();
			$("#notesDiv").hide();

			$('#titleNext').click(function() {
				var val = $("#titleInput").val();
				if (val != null) {
					title = val;
				} else {
					title = "";
				}
				$('#titleDiv').hide("fast");
				$('#suppliesDiv').show('slow');
				refreshPreview();
			});

			$('#suppliesNext').click(function() {
				$('#suppliesDiv').hide("fast");
				$('#instDiv').show('slow');

				refreshSupplies();

				refreshPreview();
			});

			$('#addSupply').click(
					function() {
						var newSupplyNode = '<li id=supply'
								+ (supplies.length + 1)
								+ '><input type="text" name="supplyInput'
								+ (supplies.length + 1) + '"id="supplyInput'
								+ (supplies.length + 1) + '" />';

						$('#suppliesList').append(newSupplyNode);
					});

			$('#addInst').click(
					function() {
						var newInstNode = '<li id=inst' + instructions.length
								+ '><input type="text" name="instInput'
								+ instructions.length + '"id="instInput'
								+ instructions.length + '" />';

						$('#instList').append(newInstNode);
					});

			$('#suppliesBack').click(function() {
				$('#titleDiv').show("slow");
				$('#suppliesDiv').hide('fast');
				refreshSupplies();
				refreshPreview();
			});

			// instructions view
			$('#instNext').click(function() {
				refreshNotesEdit();
				$('#instDiv').hide("fast");
				$('#notesDiv').show('slow');
				refreshInst();
				refreshPreview();
			});

			$('#instBack').click(function() {
				refreshNotesEdit();
				$('#instDiv').hide("slow");
				$('#suppliesDiv').show('fast');
				refreshInst();
				refreshPreview();
			});

			// click back for notes section
			$('#notesBack').click(function() {
				$('#notesDiv').hide("fast");
				$('#instDiv').show('slow');
				refreshPreview();
			});

		});