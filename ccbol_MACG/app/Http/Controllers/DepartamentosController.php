<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Departamento;

class DepartamentosController extends Controller
{
    public function index()
    {
        $departamentos = Departamento::all();
        return $departamentos;
    }

    public function store(Request $request)
    {
        $departamento = Departamento::create($request->all());
        return $departamento;
    }

    public function show(string $id)
    {
        $departamento = Departamento::find($id);
        return $departamento;
    }

    public function update(Request $request, string $id)
    {
        $departamento = Departamento::find($id);
        $departamento->update($request->all());
        return $departamento;
    }

    public function destroy(string $id)
    {
        $departamento = Departamento::find($id);
        $departamento->delete();
        return $departamento;
    }
}
