package li.cli.oc.blocks

import li.cli.oc.blocks.commons.RedstoneAware
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Material


class RedstoneIO: RedstoneAware(FabricBlockSettings.of(Material.METAL)) {

    override fun emitsRedstonePower(state: BlockState?): Boolean {
        return false
    }
}