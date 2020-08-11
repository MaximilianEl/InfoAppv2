package com.example.infoappv2.ui.institute

import android.content.Context
import android.graphics.Typeface
import android.graphics.Typeface.BOLD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseExpandableListAdapter
import androidx.appcompat.widget.AppCompatTextView
import com.example.infoappv2.R
import kotlinx.android.synthetic.main.list_group.view.*

class ExpandableListAdapter(
    val listHashMap: HashMap<String, List<String>>,
    val listDataHeader: List<String>,
    val context: Context
) : BaseExpandableListAdapter() {

    override fun getGroup(p0: Int): Any {
        return listDataHeader[p0]
    }

    override fun isChildSelectable(headerPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val headerTitle = getGroup(groupPosition) as String
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_group, parent, false)
        val listHeaderText = view.findViewById<AppCompatTextView>(R.id.lbListHeader)

        listHeaderText.setTypeface(null, Typeface.BOLD)
        listHeaderText.text = headerTitle

        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return listHashMap[listDataHeader[groupPosition]]!!.size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return listHashMap[listDataHeader[groupPosition]]!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val childText = getChild(groupPosition, childPosition) as String
        val view : View = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        val listItemText = view.findViewById<AppCompatTextView>(R.id.lbListItem)
        listItemText.text = childText

        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return listHashMap.size
    }
}


