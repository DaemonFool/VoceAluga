const selectVeiculos = document.getElementById('veiculos');

fetch('/vehicles')
    .then(response => response.json())
    .then(data => {
        data.forEach(veiculo => {
            const option = document.createElement('option');
            option.value = vehicle.getId; // Substitua pelo atributo correto do veículo que deseja usar como valor
            option.textContent = vehicle.getModelo + vehicle.getMarca; // Substitua pelo atributo correto do veículo que deseja mostrar

            selectVeiculos.appendChild(option);
        });
    })
    .catch(error => console.error('Erro ao obter os veículos:', error));





