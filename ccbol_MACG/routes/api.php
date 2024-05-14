<?php

use App\Http\Controllers\API\DepartamentosController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\ParticipantesController;
use App\Http\Controllers\LoginController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
Route::middleware('jwt.auth')->apiResource('v1/participante', ParticipantesController::class);
Route::middleware('jwt.auth')->apiResource('v1/departamento', DepartamentosController::class);

Route::post('login',[LoginController::class,'login']);