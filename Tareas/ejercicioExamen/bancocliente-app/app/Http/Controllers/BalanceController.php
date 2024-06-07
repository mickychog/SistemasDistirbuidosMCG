<?php

namespace App\Http\Controllers;

use App\Models\Balance;
use Illuminate\Http\Request;

class BalanceController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $balances = Balance::all();
        return $balances;
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $balance = Balance::create($request->all());
        return $balance;
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $balance = Balance::find($id);
        return $balance;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request,string $id)
    {
        $balance = Balance::find($id);
        
        $balance->update($request->all());
        return $balance;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $balance = Balance::find($id);
        
        $balance->delete();
        return $balance;
    }
}
