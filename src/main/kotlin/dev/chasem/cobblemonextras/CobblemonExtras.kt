package dev.chasem.cobblemonextras

import com.mojang.brigadier.CommandDispatcher
import dev.chasem.cobblemonextras.commands.*
import dev.chasem.cobblemonextras.config.CobblemonExtrasConfig
import dev.chasem.cobblemonextras.permissions.CobblemonExtrasPermissions
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback
import net.minecraft.command.CommandRegistryAccess
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

object CobblemonExtras {
    public lateinit var permissions: CobblemonExtrasPermissions
    const val MODID = "cobblemonextras"
    fun initialize() {
        System.out.println("CobblemonExtras - Initialized")
        CobblemonExtrasConfig() // must load before permissions so perms use default permission level.
        this.permissions = CobblemonExtrasPermissions()

        CommandRegistrationCallback.EVENT.register(CobblemonExtras::registerCommands)
    }

    fun registerCommands(
        dispatcher: CommandDispatcher<ServerCommandSource>,
        registry: CommandRegistryAccess,
        selection: CommandManager.RegistrationEnvironment
    ) {
        CompSee().register(dispatcher)
        PC().register(dispatcher)
        PokeSee().register(dispatcher)
        PokeShout().register(dispatcher)

        Battle().register(dispatcher)
        PokeBattle().register(dispatcher)
        PCDelete().register(dispatcher)
        PokeIVs().register(dispatcher)
    }

}
