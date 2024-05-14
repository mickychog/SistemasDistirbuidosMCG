<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class DepartamentoSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run()
    {
        $departamentos = [
            'La Paz',
            'Santa Cruz',
            'Cochabamba',
            'Oruro',
            'Potosí',
            'Tarija',
            'Chuquisaca',
            'Beni',
            'Pando'
        ];

        foreach ($departamentos as $departamento) {
            DB::table('departamentos')->insert([
                'nombre' => $departamento,
                'created_at' => now(),
                'updated_at' => now()
            ]);
        }
    }
}
