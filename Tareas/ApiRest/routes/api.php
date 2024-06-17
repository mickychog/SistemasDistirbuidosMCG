<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\UsuarioController;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\FacturaController;

Route::post('register', [UsuarioController::class, 'register']);
Route::post('login', [AuthController::class, 'login']);

Route::post('register', [UsuarioController::class, 'register']);
Route::get('usuarios', [UsuarioController::class, 'getUsers']);
Route::get('usuarios/{id}', [UsuarioController::class, 'getUser']);
Route::put('usuarios/{id}', [UsuarioController::class, 'updateUser']);
Route::delete('usuarios/{id}', [UsuarioController::class, 'deleteUser']);

Route::group(['middleware' => ['jwt.verify']], function () {    
    Route::apiResource('facturas', FacturaController::class);
});
