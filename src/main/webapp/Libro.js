function inicializarGrafico(nombres, cantidades) {
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: nombres,
            datasets: [{
                label: 'Cantidad de Libros',
                data: cantidades,
                backgroundColor: [
                    'rgba(0, 255, 0, 0.5)', // Verde con opacidad
                    'rgba(0, 255, 0, 0.5)',
                    'rgba(0, 255, 0, 0.5)',
                    'rgba(0, 255, 0, 0.5)',
                    'rgba(0, 255, 0, 0.5)',
                    'rgba(0, 255, 0, 0.5)'
                ],
                borderColor: [
                    'rgba(0, 255, 0, 1)', // Verde sólido
                    'rgba(0, 255, 0, 1)',
                    'rgba(0, 255, 0, 1)',
                    'rgba(0, 255, 0, 1)',
                    'rgba(0, 255, 0, 1)',
                    'rgba(0, 255, 0, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                // Configuración para el plugin 3D
                'chartjs-plugin-3d': {
                    enabled: true,
                    mode: '3d',
                    rotation: {
                        x: 0,
                        y: 0,
                        z: 0
                    },
                    perspective: 1000
                }
            }
        }
    });
}

// Llama a la función con datos de ejemplo

inicializarGrafico(['Libros A', 'Libros B', 'Libros C'], [10, 20, 30]);
