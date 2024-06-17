<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;
use App\Models\User;
use Firebase\JWT\JWT;
use Firebase\JWT\Key;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Log;

class AuthController extends Controller
{
    private $jwt_secret;

    public function __construct()
    {
        $this->jwt_secret = env('JWT_SECRET');
    }
    

    public function login(Request $request)
    {
        
        $validator = Validator::make($request->all(), [
            'correoelectronico' => 'required|string|email',
            'password' => 'required|string',
        ]);
        
        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 400);
        }

        $user = User::where('correoelectronico', $request->correoelectronico)->first();

    if (!$user) {
        return response()->json(['error' => 'Usuario no encontrado'], 401);
    }
    Log::channel('console')->info($request->password);
    logger($user->password);
    if (Hash::check($request->password, $user->password)) {
        $payload = [
            'iss' => "laravel-jwt", // Issuer of the token
            'sub' => $user->id, // Subject of the token
            'iat' => time(), // Time when JWT was issued.
            'exp' => time() + 60 * 60 // Expiration time
        ];

        $token = JWT::encode($payload, $this->jwt_secret, 'HS256');

    return response()->json(['token' => $token]);
    
    }
    else{
        return response()->json(['error' => 'Contraseña invalida'], 401);
    }

    
    }
    

    public function me(Request $request)
    {
        return response()->json(auth()->user());
    }
}
