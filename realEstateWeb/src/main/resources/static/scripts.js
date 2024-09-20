function submitForm() {
    const form = document.getElementById('itemForm');
    const formData = new FormData(form);

    const property = {
        name: formData.get('name'),
        owner: formData.get('owner'),
        price: formData.get('price'),
        type: formData.get('type'),
        contact: formData.get('contact'),
        address: formData.get('address'),
        availability: formData.get('availability')
    };

    fetch('http://localhost:8080/properties', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(property)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}