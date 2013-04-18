package fuj1n.awesomeMod;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		int x, y, z, meta;
		if(packet.channel.equals("fuj1nAMetaPacket")){
	        DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	        try {
                meta = inputStream.readShort();
                x = inputStream.readInt();
                y = inputStream.readInt();
                z = inputStream.readInt();
        } catch (IOException e) {
                e.printStackTrace();
                return;
        }
	        EntityPlayerMP playerMP = (EntityPlayerMP)player;
			World world = playerMP.worldObj;
			world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			world.updateAllLightTypes(x, y, z);
		}
		
	}

}
