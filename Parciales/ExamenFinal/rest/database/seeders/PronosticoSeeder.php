<?php

use Illuminate\Database\Seeder;
use App\Models\Pronostico;

class PronosticoSeeder extends Seeder
{
    public function run()
    {
        $data = [
            ['fecha' => '2024-06-04', 'temperatura' => 21],
            ['fecha' => '2024-06-05', 'temperatura' => 22],
            ['fecha' => '2024-06-06', 'temperatura' => 25],
            ['fecha' => '2024-06-07', 'temperatura' => 26],
            ['fecha' => '2024-06-08', 'temperatura' => 27],
            ['fecha' => '2024-06-09', 'temperatura' => 22],
            ['fecha' => '2024-06-10', 'temperatura' => 21],
            ['fecha' => '2024-06-11', 'temperatura' => 22],
            ['fecha' => '2024-06-12', 'temperatura' => 20],
            ['fecha' => '2024-06-13', 'temperatura' => 19],
            ['fecha' => '2024-06-14', 'temperatura' => 19],
            ['fecha' => '2024-06-15', 'temperatura' => 18],
            ['fecha' => '2024-06-16', 'temperatura' => 17],
            ['fecha' => '2024-06-17', 'temperatura' => 16],
            ['fecha' => '2024-06-18', 'temperatura' => 16],
            ['fecha' => '2024-06-19', 'temperatura' => 15],
            ['fecha' => '2024-06-20', 'temperatura' => 17],
            ['fecha' => '2024-06-21', 'temperatura' => 19],
            ['fecha' => '2024-06-22', 'temperatura' => 20],
            ['fecha' => '2024-06-23', 'temperatura' => 21],
        ];

        foreach ($data as $item) {
            Pronostico::create($item);
        }
    }
}
