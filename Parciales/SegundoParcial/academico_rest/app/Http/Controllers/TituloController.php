<?php

namespace App\Http\Controllers;

use App\Models\Titulo;
use Illuminate\Http\Request;

class TituloController extends Controller
{
    public function index()
    {
        return Titulo::all();
    }

    public function show($id)
    {
        return Titulo::find($id);
    }

    public function store(Request $request)
    {
        $titulo = Titulo::create($request->all());
        return $titulo;
    }

    public function update(Request $request, $id)
    {
        $titulo = Titulo::findOrFail($id);
        $titulo->update($request->all());
        return $titulo;
    }

    public function destroy($id)
    {
        $titulo = Titulo::findOrFail($id);
        Titulo::findOrFail($id)->delete();
        return $titulo;
    }
}
