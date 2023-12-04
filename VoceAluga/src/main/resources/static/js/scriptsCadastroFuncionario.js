document.getElementById('meuFormulario').addEventListener('submit', function(event) {
    event.preventDefault(); 
  
    
    localStorage.setItem('cadastroSucesso', 'true');
  
    
    window.location.href = 'home.html?message=Funcionario cadastrado com sucesso';
  });


    var cpfMask = IMask(document.getElementById('cpf'), {
        mask: '000.000.000-00'
    });

    var telefoneMask = IMask(document.getElementById('telefone'), {
        mask: '(00) 00000-0000'
    });
