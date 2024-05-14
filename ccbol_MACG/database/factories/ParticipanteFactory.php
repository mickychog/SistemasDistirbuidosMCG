<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Participante>
 */
class ParticipanteFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'ci'=>fake()->numberBetween(1111111,99999999),
            'nombres'=>fake()->firstName(),
            'apellidos'=>fake()->lastName(),
            'sexo'=>'M',
            'fecha_nacimiento'=>fake()->date()
        ];
    }
}
