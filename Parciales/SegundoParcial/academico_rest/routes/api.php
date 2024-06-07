<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TituloController;


Route::get('titulos', [TituloController::class, 'index']);
Route::get('titulos/{id}', [TituloController::class, 'show']);
Route::post('titulos', [TituloController::class, 'store']);
Route::put('titulos/{id}', [TituloController::class, 'update']);
Route::delete('titulos/{id}', [TituloController::class, 'destroy']);
