package com.ffcs.crmd.cas.core.ddd.api.dto;

import com.ffcs.crmd.cas.core.ddd.api.dto.impl.CrmdBaseDTO;


public class TreeNodeStateDTO extends CrmdBaseDTO {
    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1598179584838497003L;
    
    /**
     * 节点是否打开.
     */
    private boolean           opened;
    
    /**
     * 节点是否选中.
     */
    private boolean           selected;
    
    /**
     * 
     */
    private boolean           checked;
    
    /**
     * 节点是否已经加载过了
     */
    private boolean           loaded;
    
    public boolean isOpened() {
        return opened;
    }
    
    public void setOpened(boolean opened) {
        this.opened = opened;
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    public boolean isChecked() {
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    public boolean isLoaded() {
        return loaded;
    }
    
    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
    
}
