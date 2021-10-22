isntfiltros.addEventListener('click', function(event){
    event.preventDefault();
});
isfiltros.addEventListener('click', function(event){
    event.preventDefault();
});
isntfiltros.addEventListener('click', function(){
   isntfiltros.hidden=true;
   mostrar.hidden=true;
   isfiltros.hidden=false;
   datos.hidden=false;
   datos.style.display="grid";
   filtrar.hidden=false;
});

isfiltros.addEventListener('click', function(){
   isntfiltros.hidden=false;
   mostrar.hidden=false;
   isfiltros.hidden=true;
   datos.hidden=true;
   datos.style.display="none";
   filtrar.hidden=true;
   nombre.placeholder=nombre.value;
   nombre.value='';
   apellido.placeholder=apellido.value;
   apellido.value='';
   minimo.placeholder=minimo.value;
   minimo.value='';
   maximo.placeholder=maximo.value;
   maximo.value='';
   departamento.placeholder=departamento.value;
   departamento.value='';
});


