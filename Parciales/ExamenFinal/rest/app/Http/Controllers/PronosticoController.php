<?php

namespace App\Http\Controllers;

use App\Models\Pronostico;
use Illuminate\Http\Request;

class PronosticoController extends Controller
{
    public function index()
    {
        return Pronostico::all();
    }

    public function store(Request $request)
    {
        
        return Pronostico::create($request->all());
    }

    public function show($id)
    {
        return Pronostico::findOrFail($id);
    }

    public function update(Request $request, $id)
    {
        $pronostico = Pronostico::findOrFail($id);
        $pronostico->update($request->all());

        return $pronostico;
    }

    public function destroy($id)
    {
        $pronostico = Pronostico::findOrFail($id);
        $pronostico->delete();

        return $pronostico;
    }
}
