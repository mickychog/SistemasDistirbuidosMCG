<?php

namespace App\Http\Controllers;

use App\Models\Usuario;
use Illuminate\Http\Request;

class UsuarioController extends Controller
{
    public function index()
{
    $usuarios = Usuario::all();
    return $usuarios;
}

/**
 * Almacenar un nuevo recurso en el almacenamiento.
 */
public function store(Request $request)
{
    $usuario = Usuario::create($request->all());
    return $usuario;
}

/**
 * Mostrar el recurso especificado.
 */
public function show(string $id)
{
    $usuario = Usuario::find($id);
    return $usuario;
}

/**
 * Actualizar el recurso especificado en el almacenamiento.
 */
public function update(Request $request, string $id)
{
    $usuario = Usuario::find($id);
    $usuario->update($request->all());
    return $usuario;
}

/**
 * Eliminar el recurso especificado del almacenamiento.
 */
public function destroy(string $id)
{
    $usuario = Usuario::find($id);
    $usuario->delete();
    return $usuario;
}

}
