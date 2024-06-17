<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up()
{
    Schema::create('facturas', function (Blueprint $table) {
        $table->id();
        $table->string('nro', 30);
        $table->date('fecha');
        $table->string('cuf', 30);
        $table->string('cufd', 30);
        $table->decimal('monto_total', 10, 2);
        $table->timestamps();
    });
}


    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('facturas');
    }
};
