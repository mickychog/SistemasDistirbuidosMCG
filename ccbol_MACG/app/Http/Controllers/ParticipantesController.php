<?php

namespace App\Http\Controllers;

use App\Models\Participante;
use Illuminate\Http\Request;

class ParticipantesController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $participantes=Participante::all();
        return $participantes;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $participante=Participante::create($request->all());
        return $participante;
        
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $participante=Participante::find($id);
        
        return $participante;

    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $participante=Participante::find($id);
        $participante->update($request->all());
        return $participante;

    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $participante=Participante::find($id);
        $participante->delete();
        return $participante;
    }
}
