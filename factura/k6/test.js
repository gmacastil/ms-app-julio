import http from 'k6/http';
import { check, sleep } from 'k6';

// Configuración de la prueba
export const options = {
  stages: [
    { duration: '30s', target: 10 }, // Ramp up a 10 usuarios en 30s
    { duration: '1m', target: 10 },  // Mantener 10 usuarios por 1 minuto
    { duration: '30s', target: 0 },  // Ramp down a 0 usuarios en 30s
  ],
  thresholds: {
    http_req_duration: ['p(95)<500'], // 95% de las requests deben ser < 500ms
    http_req_failed: ['rate<0.1'],    // Menos del 10% de requests fallidas
  },
};

// Función principal que ejecuta cada usuario virtual
export default function () {
  // Generar ID de factura aleatorio entre 22 y 41
  const facturaId = Math.floor(Math.random() * 20) + 22;
  
  // Configurar headers
  const params = {
    headers: {
      'Accept': 'application/json',
    },
  };
  
  // Realizar la petición GET
  const response = http.get(`http://localhost:8085/api/facturas/${facturaId}`, params);
  
  // Verificaciones
  check(response, {
    'status es 200': (r) => r.status === 200,
    'respuesta es JSON': (r) => r.headers['Content-Type'] && r.headers['Content-Type'].includes('application/json'),
    'tiempo de respuesta < 500ms': (r) => r.timings.duration < 500,
  });
  
  // Pausa entre requests (simula comportamiento real de usuario)
  sleep(1);
}

// Función de setup (opcional) - se ejecuta una vez al inicio
export function setup() {
  console.log('Iniciando prueba de carga para API de facturas');
}

// Función de teardown (opcional) - se ejecuta una vez al final
export function teardown(data) {
  console.log('Prueba de carga completada');
}