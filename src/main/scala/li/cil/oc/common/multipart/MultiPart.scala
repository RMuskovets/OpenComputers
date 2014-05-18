package li.cil.oc.common.multipart

import codechicken.lib.vec.BlockCoord
import codechicken.multipart.MultiPartRegistry.{IPartConverter, IPartFactory}
import codechicken.multipart.{TMultiPart, MultiPartRegistry}
import li.cil.oc.common.tileentity.Cable
import li.cil.oc.{Settings, Blocks}
import net.minecraft.world.World
import net.minecraftforge.common.MinecraftForge
import java.util

object MultiPart extends IPartFactory with IPartConverter {
  def init() {
    MultiPartRegistry.registerConverter(this)
    MultiPartRegistry.registerParts(this, Array(Settings.namespace + "cable"))
    MinecraftForge.EVENT_BUS.register(EventHandler)
  }

  override def createPart(name: String, client: Boolean): TMultiPart = {
    if (name.equals(Settings.namespace + "cable"))
      return new CablePart()
    null
  }

  override def blockTypes = util.Arrays.asList(Blocks.cable.parent)

  override def convert(world: World, pos: BlockCoord) = {
    world.getTileEntity(pos.x, pos.y, pos.z) match {
      case cable: Cable => new CablePart(Some(cable.node))
      case _ => null
    }
  }
}
