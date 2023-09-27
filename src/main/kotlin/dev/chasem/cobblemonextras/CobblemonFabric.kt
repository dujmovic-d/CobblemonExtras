package dev.chasem.cobblemonextras

import net.fabricmc.api.ModInitializer

class CobblemonFabric : ModInitializer {
    @Override
    override fun onInitialize() {
        CobblemonExtras.initialize()
        println("Initialized Cobblemon Extras")
    }
}