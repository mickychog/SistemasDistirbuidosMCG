<?php

namespace App\Http\Controllers;

use App\Models\Factura;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class FacturaController extends Controller
{
    public function index()
    {
        return response()->json(Factura::all());
    }

    public function store(Request $request)
    {
            $validator = Validator::make($request->all(), [
            'nro' => 'required|string|max:30',
            'fecha' => 'required|date',
            'cuf' => 'required|string|max:30',
            'cufd' => 'required|string|max:30',
            'monto_total' => 'required|numeric',
        ]);

        $factura = Factura::create($request->all());

        return response()->json($factura, 201);
    }

    public function show($id)
    {
        return response()->json(Factura::findOrFail($id));
    }

    public function update(Request $request, $id)
    {
        $validator = Validator::make($request->all(), [
            'nro' => 'required|string|max:30',
            'fecha' => 'required|date',
            'cuf' => 'required|string|max:30',
            'cufd' => 'required|string|max:30',
            'monto_total' => 'required|numeric',
        ]);

        $factura = Factura::findOrFail($id);
        $factura->update($request->all());

        return response()->json($factura, 200);
    }

    public function destroy($id)
    {
        Factura::findOrFail($id)->delete();

        return response()->json(null, 204);
    }
}

