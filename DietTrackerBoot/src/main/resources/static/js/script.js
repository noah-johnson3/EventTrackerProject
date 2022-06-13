window.addEventListener('load', function(evt) {
	console.log('script.js loaded');
	init();
});

function init() {
	document.dietForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let dietId = document.dietForm.dietId.value;
		if (!isNaN(dietId) && dietId > 0) {
			getDiet(dietId);
		}
	});
	document.newDietForm.addDietButton.addEventListener('click', createDiet);
}

function createDiet(e) {

	e.preventDefault();
	let form = document.newDietForm;
	let newDiet = {
		name: form.name.value,
		calories: form.calories.value,
		protein: form.protein.value,
		carb: form.carb.value,
		fat: form.fat.value
	}
	sendNewDiet(newDiet);
}

function sendNewDiet(newDiet) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/diet');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let diet = JSON.parse(xhr.responseText);
				displayDiet(diet);
			} else {
				displayError('Error creating film: ' + xhr.status + " " + xhr.statusText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newDiet));
}
function sendNewDiet(newDiet) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/diet');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let diet = JSON.parse(xhr.responseText);
				displayDiet(diet);
			} else {
				displayError('Error creating film: ' + xhr.status + " " + xhr.statusText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(newDiet));
}

function updateDiet(e) {


	e.preventDefault();

	let form = document.newDietForm;
	let updatedDiet = {
		id: form.id.value,
		name: form.name.value,
		calories: form.calories.value,
		protein: form.protein.value,
		carb: form.carb.value,
		fat: form.fat.value
	}
	sendUpdate(updatedDiet);
}

function sendUpdate(diet) {
	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/diet/${diet.id}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.status === 201) {
				let diet = JSON.parse(xhr.responseText);
				displayDiet(diet);
			} else {
				displayError('Error updating film: ' + xhr.status + " " + xhr.statusText);
			}
		}
	};
	xhr.setRequestHeader('Content-type', 'application/json');
	xhr.send(JSON.stringify(diet));
}

function getDiet(dietId) {
	let xhr = new XMLHttpRequest();

	xhr.open('GET', `api/diet/${dietId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 && xhr.responseText) {
				let diet = JSON.parse(xhr.responseText);
				displayDiet(diet);
			} else {
				displayError('Diet not found.')
			}
		}
	};
	xhr.send();
}

function deleteDiet(e) {
	e.preventDefault();
	let xhr = new XMLHttpRequest();
	let dietId = e.target.previousElementSibling.previousElementSibling.value;
	xhr.open('DELETE', `api/diet/${dietId}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 204) {
				displayDeleted('Diet has been deleted');
			} else {
				displayError('Diet not found.')
			}
		}

	};
	
		xhr.send();
}
function displayDeleted(message) {
	let dataDiv = document.getElementById('dietDeleteData');
	dataDiv.textContent = '';
	dataDiv.textContent = message;
}
function displayError(message) {
	let dataDiv = document.getElementById('dietData');
	dataDiv.textContent = '';
	dataDiv.textContent = message;
}

function displayDiet(diet) {
	let dataDiv = document.getElementById('dietData');
	dataDiv.textContent = '';
	let h1 = document.createElement('hi');
	h1.textContent = diet.name;
	dataDiv.appendChild(h1);
	let elem = document.createElement('ul');
	dataDiv.appendChild(elem);
	elem = document.createElement('li');
	elem.textContent = "Calories: " + diet.calories;
	dataDiv.appendChild(elem);
	elem = document.createElement('li');
	elem.textContent = "Protein: " + diet.protein;
	dataDiv.appendChild(elem);
	elem = document.createElement('li');
	elem.textContent = "Carbs: " + diet.carb;
	dataDiv.appendChild(elem);
	elem = document.createElement('li');
	elem.textContent = "Fat: " + diet.fat;
	dataDiv.appendChild(elem);

	if (document.newDietForm.id) {
		document.newDietForm.removeChild(document.newDietForm.id);
	}

	let hiddenDietId = document.createElement('input');
	hiddenDietId.value = diet.id;
	hiddenDietId.hidden = true;
	hiddenDietId.name = "id";
	document.newDietForm.appendChild(hiddenDietId);

	if (document.newDietForm.updateButton) {
		document.newDietForm.removeChild(document.newDietForm.updateButton)
	}


	let updateButton = document.createElement('button');
	updateButton.textContent = "Update Diet";
	updateButton.name = "updateButton";
	document.newDietForm.appendChild(updateButton);
	updateButton.addEventListener('click', updateDiet);

	if (document.newDietForm.deleteButton) {
		document.newDietForm.removeChild(document.newDietForm.deleteButton)
	}

	let deleteButton = document.createElement('button');
	deleteButton.textContent = "Delete Diet";
	deleteButton.name = "deleteButton";
	document.newDietForm.appendChild(deleteButton);
	deleteButton.addEventListener('click', deleteDiet);
}