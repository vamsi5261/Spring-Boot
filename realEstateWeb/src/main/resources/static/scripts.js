document.getElementById('propertyForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const property = {
        name: document.getElementById('name').value,
        owner: document.getElementById('owner').value,
        price: document.getElementById('price').value,
        type: document.getElementById('type').value,
        contact: document.getElementById('contact').value,
        address: document.getElementById('address').value,
        availability: document.getElementById('availability').value
    };

    fetch('/api/properties', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(property)
    })
    .then(response => response.json())
    .then(data => {
        addPropertyToTable(data);
        document.getElementById('propertyForm').reset();
    });
});

function addPropertyToTable(property) {
    const table = document.getElementById('propertiesTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();
    newRow.insertCell(0).innerText = property.id;
    newRow.insertCell(1).innerText = property.name;
    newRow.insertCell(2).innerText = property.owner;
    newRow.insertCell(3).innerText = property.price;
    newRow.insertCell(4).innerText = property.type;
    newRow.insertCell(5).innerText = property.contact;
    newRow.insertCell(6).innerText = property.address;
    newRow.insertCell(7).innerText = property.availability;
    const actionsCell = newRow.insertCell(8);
    const bookButton = document.createElement('button');
    bookButton.innerText = 'Book';
    bookButton.onclick = () => bookProperty(property.id);
    actionsCell.appendChild(bookButton);
}

function bookProperty(propertyId) {
    const userName = prompt('Enter your name:');
    const userContact = prompt('Enter your contact:');
    if (userName && userContact) {
        const booking = {
            propertyId: propertyId,
            userName: userName,
            userContact: userContact
        };

        fetch('/api/bookings', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(booking)
        })
        .then(response => response.json())
        .then(data => {
            alert('Property booked successfully!');
        });
    }
}

function loadProperties() {
    fetch('/api/properties')
    .then(response => response.json())
    .then(data => {
        data.forEach(property => addPropertyToTable(property));
    });
}

window.onload = loadProperties;
