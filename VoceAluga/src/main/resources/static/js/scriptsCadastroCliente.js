document.getElementById('form').addEventListener('submit', function(event) {
    event.preventDefault(); 
  
    
    localStorage.setItem('cadastroSucesso', 'true');
    window.location.href = 'home.html?message=Cliente cadastrado com sucesso';
    

  });
var dnMask = IMask(document.getElementById('dataNascimento'), {
        mask: '00/00/0000'
    });

    var cpfMask = IMask(document.getElementById('cpf'), {
        mask: '000.000.000-00'
    });

    var telefoneMask = IMask(document.getElementById('telefone'), {
        mask: '(00) 00000-0000'
    });

const form = document.getElementById('form');

form.addEventListener('submit', async event => {
  event.preventDefault();

  const data = new FormData(form);
  const value = Object.fromEntries(data.entries());
  console.log(value);

  try {
    const res = await fetch(
      'Http://localhost:8080/clients',
      {
        method: 'POST',
        body: JSON.stringify(value),
        headers: {
              "Content-Type": "application/json",
            },
      },
    );

    const resData = await res.json();

    console.log(resData);
  } catch (err) {
    console.log(err.message);
  }
});

