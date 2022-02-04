select 
v.placa, v.id_empresa,
ti.nombre, 
e.numero_documento,
e.nombre,
sum(1) cantidad
from vehiculo v 
inner join empresa e on v.id_empresa = e.id 
inner join tipo_identificacion ti on e.id_tipo_identificacion = ti.id
inner join conductor_vehiculo cv on cv.id_vehiculo = v.id
group by v.placa 
having count(*) > 2